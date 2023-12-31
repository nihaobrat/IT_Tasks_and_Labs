import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class SoldItem {
    String name;
    int price;

    SoldItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class MonsterEnergyShop {
    private final List<SoldItem> soldItems = new CopyOnWriteArrayList<>();

    public void addItem(SoldItem item) {
        soldItems.add(item);
    }

    public void showSoldItems() {
        for (SoldItem item : soldItems) {
            System.out.println("Название: " + item.name + ", Цена: " + item.price);
        }
    }

    public int calculateTotalSales() {
        int total = 0;
        for (SoldItem item : soldItems) {
            total += item.price;
        }
        return total;
    }

    public String findMostPopularItem() {
        // определение наиболее популярного товара (по количеству проданных единиц)
        // предполагается, что это товар, который продавался чаще всего.
        String mostPopularItemName = null;
        int maxCount = 0;

        for (SoldItem item : soldItems) {
            int count = 0;
            for (SoldItem subItem : soldItems) {
                if (item.name.equals(subItem.name)) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mostPopularItemName = item.name;
            }
        }

        return mostPopularItemName;
    }

    public static void main(String[] args) {
        MonsterEnergyShop shop = new MonsterEnergyShop();

        shop.addItem(new SoldItem("Monster Original", 150));
        shop.addItem(new SoldItem("Monster Ultra", 170));
        shop.addItem(new SoldItem("Monster Original", 150));

        System.out.println("Корзина:");
        shop.showSoldItems();

        System.out.println("Сумма к оплате: " + shop.calculateTotalSales() + "\n");

        System.out.println("Самый популярный продукт: " + shop.findMostPopularItem());
    }
}
