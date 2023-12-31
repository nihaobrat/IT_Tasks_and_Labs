import java.util.*;
import java.util.concurrent.*;

public class Sklad {

    private final List<Goods> goodsList = Collections.synchronizedList(new ArrayList<>());
    private final int MAX_WEIGHT = 150;
    private int currentWeight = 0;

    public static void main(String[] args) {
        Sklad sklad = new Sklad();
        sklad.initializeGoods();
        sklad.transferGoods();
    }

    public void initializeGoods() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int weight = random.nextInt(15) + 1;  
            Goods goods = new Goods(weight);
            goodsList.add(goods);
        }
    }

    public void transferGoods() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Boolean> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < 3; i++) {
            Worker worker = new Worker();
            completionService.submit(worker);
        }

        executor.shutdown();

        try {
            for (int i = 0; i < 3; i++) {
                Future<Boolean> future = completionService.take();
                Boolean result = future.get();
                if (result) {
                    System.out.println("Товары успешно перевезены работником " + (i + 1));
                } else {
                    System.out.println("Работнику " + (i + 1) + " не удалось перевезти товар");
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    class Goods {
        int weight;

        public Goods(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    class Worker implements Callable<Boolean> {

        @Override
        public Boolean call() {
            while (true) {
                Goods goods = null;
                synchronized (goodsList) {
                    if (!goodsList.isEmpty()) {
                        goods = goodsList.remove(0);
                    }
                }

                if (goods == null) {
                    break;
                }

                synchronized (this) {
                    currentWeight += goods.getWeight();
                    if (currentWeight >= MAX_WEIGHT) {
                        currentWeight = 0;
                        System.out.println("Перенос товара на другой склад...");
                        try {
                            Thread.sleep(1000); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
