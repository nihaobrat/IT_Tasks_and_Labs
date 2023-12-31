import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Matrix {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int numOfThreads = 3; // количество потоков

        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        List<Future<Integer>> futures = new ArrayList<>();

        int rowsPerThread = matrix.length / numOfThreads;
        for (int i = 0; i < numOfThreads; i++) {
            final int startRow = i * rowsPerThread;
            final int endRow = (i + 1) * rowsPerThread;
            Future<Integer> future = executorService.submit(() -> findMax(matrix, startRow, endRow));
            futures.add(future);
        }

        int maxElement = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            maxElement = Math.max(maxElement, future.get());
        }

        System.out.println("MAX: " + maxElement);

        executorService.shutdown();
    }

    private static int findMax(int[][] matrix, int startRow, int endRow) {
        int max = Integer.MIN_VALUE;
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }
}
