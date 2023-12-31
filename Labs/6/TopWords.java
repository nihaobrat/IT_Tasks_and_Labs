import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // указываем путь к файлу
        String filePath = "C:\\Users\\stekkz\\Desktop\\ИТИП\\Labs\\6\\words.txt";
        // создаем объект File
        File file = new File(filePath);
        // создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> wordCount = new HashMap<>();

        // читаем файл по словам и добавляем их в Map
        while (scanner != null && scanner.hasNext()) {
            String word = scanner.next().replaceAll("\\W", "").toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // закрываем Scanner
        if (scanner != null) {
            scanner.close();
        }

        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        // сортируем список по убыванию количества повторений
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // выводим топ-10 слов
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            // выводим результат
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
