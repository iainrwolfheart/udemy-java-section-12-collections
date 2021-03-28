import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> stockList;

    public StockList() {
        this.stockList = new HashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = stockList.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustStock(inStock.getQtyInStock());
            }
            stockList.put(item.getName(), item);
            return item.getQtyInStock();
        }
        return 0;
    }

    public int reserveStock(String item, int qty) {
        StockItem inStock = stockList.getOrDefault(item, null);

        if ((inStock != null) && (inStock.getQtyInStock() - inStock.getQtyReserved() >= qty) && (qty > 0)) {
            inStock.reserveStockOfItem(qty);
            return qty;
        }
        else System.out.println("Unable to add that amount of " + inStock.getName() + " to basket. Only "
                + (inStock.getQtyInStock() - inStock.getQtyReserved()) + " left in stock.");
        return 0;
    }

    public int unreserveStock(String item, int qty) {
        StockItem inStock = stockList.getOrDefault(item, null);

        if ((inStock != null) && (qty - inStock.getQtyReserved() < 0) && (qty > 0)) {
            inStock.unreserveStockOfItem(qty);
            return qty;
        }
        else System.out.println("Unable to remove that amount of " + inStock.getName() + " from your basket.");
        return 0;
    }

    public int sellStock(String item, int qty) {
        StockItem inStock = stockList.getOrDefault(item, null);

        if ((inStock != null) && (inStock.getQtyInStock() >= qty) && (qty > 0)) {
            inStock.adjustStock(-qty);
            return qty;
        }
        return 0;
    }

    public StockItem getItemByKey(String key) {
        return stockList.get(key);
    }

    public Map<String, StockItem> getAllItems() {
        return Collections.unmodifiableMap(stockList);
    }

    public Map<String, Double> getPriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : stockList.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override
    public String toString() {
        String output = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : stockList.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.getQtyInStock();

            output += stockItem + ": " + stockItem.getQtyInStock() + " in stock. " +
                    "Value of stock: £" + String.format("%.2f", itemValue) +
                    ". Reserved Stock: " + stockItem.getQtyReserved() + ".\n";
            totalCost += itemValue;
        }
        return output += "Total stock value is £" + String.format("%.2f",totalCost) + ".";
    }
}
