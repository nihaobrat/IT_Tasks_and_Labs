import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumCalculator {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numOfThreads = 2; // количество потоков

        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        List<Future<Integer>> futures = new ArrayList<>();

        int chunkSize = array.length / numOfThreads;
        for (int i = 0; i < numOfThreads; i++) {
            final int start = i * chunkSize;
            final int end = (i + 1) * chunkSize;
            Future<Integer> future = executorService.submit(() -> calculateSum(array, start, end));
            futures.add(future);
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        System.out.println("Сумма: " + totalSum);

        executorService.shutdown();
    }

    private static int calculateSum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
