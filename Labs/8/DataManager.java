import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.*;

public class DataManager {
    private List<String> data = new ArrayList<>();
    private List<Method> processors = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        for (Method method : processor.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(DataProcessor.class)) {
                processors.add(method);
            }
        }
    }

    public void loadData(String source) throws IOException {
        data = Files.readAllLines(Paths.get(source));
    }


    public void processData() {
        ExecutorService executor = Executors.newFixedThreadPool(processors.size());

        List<Future<String>> futures = processors.stream()
                .map(method -> executor.submit(() -> {
                    try {
                        Object result = method.invoke(null, data);
                        if (result instanceof List<?>) {
                            List<?> resultList = (List<?>) result;
                            if (resultList.stream().allMatch(item -> item instanceof String)) {
                                List<String> processedData = resultList.stream()
                                        .map(String::valueOf)
                                        .collect(Collectors.toList());
                                String comment = method.getAnnotation(DataProcessor.class).comment();
                                return comment + "\n" + processedData.toString() + "\n";
                            } else {
                                return "Error: Список содержит элементы, которые не являются строковыми.\n";
                            }
                        } else {
                            return "Error: Метод не вернул List<String>.\n";
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        return "";
                    }
                }))
                .collect(Collectors.toList());

        data = futures.stream().flatMap(future -> {
            try {
                return Stream.of(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return Stream.empty();
        }).collect(Collectors.toList());

        executor.shutdown();
    }


    public void saveData(String destination) throws IOException {
        Files.write(Paths.get(destination), data);
    }
}
