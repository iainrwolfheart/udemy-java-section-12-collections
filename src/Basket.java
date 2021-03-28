import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> basketItems;

    public Basket(String name) {
        this.name = name;
        this.basketItems = new HashMap<>();
    }

    public int addToBasket(StockItem item, int qty) {
        if (item != null && qty > 0) {
            int inBasket = basketItems.getOrDefault(item, 0);
            basketItems.put(item, inBasket + qty);
            return inBasket;
        }
        return 0;
    }
    public int removeFromBasket(StockItem item, int qty) {
        if (item != null && qty > 0) {
            int inBasket = basketItems.getOrDefault(item, 0);

            if (inBasket + qty > 0) {
                basketItems.put(item, inBasket + qty);
            } else if (inBasket + qty == 0) {
                basketItems.remove(item);
            }
            return qty;
        }
        return 0;
    }

    public void clearBasket() {
        this.basketItems.clear();
    }

    public Map<StockItem, Integer> getAllItems() {
        return Collections.unmodifiableMap(basketItems);
    }

    @Override
    public String toString() {
        String output = "Shopping basket " + name + " contains " +
        basketItems.size() + ((basketItems.size() == 1) ? " item." : " items.") +"\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : basketItems.entrySet()) {
            output += item.getKey() + ". " + item.getValue() +
                    " purchased.\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return output + "Total cost of basket is " + String.format("%.2f", totalCost);
    }
}
