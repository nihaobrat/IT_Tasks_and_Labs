import java.util.*;

class Order {
    String[] dishes;
    double cost;
    String orderTime;

    Order(String[] dishes, double cost, String orderTime) {
        this.dishes = dishes; 
        this.cost = cost; 
        this.orderTime = orderTime; 
    }
}

public class RestaurantOrders {
    private Map<Integer, Order> ordersTable;

    public RestaurantOrders() {
        ordersTable = new HashMap<>(); 
    }

    public void insertOrder(int tableNumber, Order order) {
        ordersTable.put(tableNumber, order); 
    }

    public Order findOrder(int tableNumber) {
        return ordersTable.get(tableNumber); 
    }

    public void deleteOrder(int tableNumber) {
        ordersTable.remove(tableNumber); 
    }

    public static void main(String[] args) {
        
        RestaurantOrders restaurantOrders = new RestaurantOrders();

        String[] dishes1 = {"Блюдо 1", "Блюдо 2"};
        Order order1 = new Order(dishes1, 100.50, "14:48");
        restaurantOrders.insertOrder(1, order1); 

        Order foundOrder = restaurantOrders.findOrder(1);
        if (foundOrder != null) {
            
            System.out.println("Заказ найден: " + Arrays.toString(foundOrder.dishes) + ", " + foundOrder.cost + ", " + foundOrder.orderTime);
        } else {
            
            System.out.println("Заказ не найден");
        }

        restaurantOrders.deleteOrder(1);
        foundOrder = restaurantOrders.findOrder(1);
        if (foundOrder == null) {
            
            System.out.println("Заказ успешно удалён");
        } else {
            
            System.out.println("Не удалось удалить заказ");
        }
    }
}