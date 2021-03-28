import java.util.Map;

public class ShoppingMain {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Tofu", 1.99, 20);
        stockList.addStock(temp);

        temp = new StockItem("Cheesecake", 2.29, 5);
        stockList.addStock(temp);

        temp = new StockItem("Eggs", 2.39, 200);
        stockList.addStock(temp);

        temp = new StockItem("Dark Chocolate", 1.99, 15);
        stockList.addStock(temp);

        temp = new StockItem("Broccoli", 0.55, 400);
        stockList.addStock(temp);

        System.out.println(stockList + "\n");

        Basket basket = new Basket("Iain's Basket");
        addItemsToBasket(basket, "Eggs", 5);
        addItemsToBasket(basket, "Dark Chocolate", 2);
//        addItemsToBasket(basket, "Bog roll", 6);
        System.out.println(basket);

        System.out.println(stockList + "\n");

//        for (Map.Entry<String, Double> price: stockList.getPriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

        removeItemsFromBasket(basket, "Dark Chocolate", 3);
        System.out.println(stockList + "\n");

        checkoutBasket(basket);
    }

    public static int addItemsToBasket(Basket basket, String item, int qty) {
        StockItem stockItem = stockList.getItemByKey(item);
        if (stockItem == null) {
            System.out.println("We don't sell those.");
            return 0;
        }
        if (stockList.reserveStock(item, qty) != 0) {
            basket.addToBasket(stockItem, qty);
//            basket.getAllItems().forEach((itemInBasket, itemQty) -> System.out.println(itemInBasket.getQtyReserved()));
            return qty;
        }
        return 0;
    }

    public static int removeItemsFromBasket(Basket basket, String item, int qty) {
        StockItem stockItem = stockList.getItemByKey(item);
        if (stockItem == null) {
            System.out.println("We don't sell those.");
            return 0;
        }
        if (stockList.unreserveStock(item, qty) != 0) {
            basket.removeFromBasket(stockItem, qty);
            return qty;
        }
        return 0;
    }

    public static void checkoutBasket(Basket basket) {
        // Iterate through items in basket
        for (Map.Entry<StockItem, Integer> item : basket.getAllItems().entrySet()) {
            System.out.println("Contents of basket:\n" + item.getKey().getQtyReserved() +
                    "x " + item.getKey().getName() +
                    ", total £" + String.format("%.2f",
                    item.getKey().getPrice() * item.getKey().getQtyReserved()));
            // Call StockList.sellStock() which should adjust each item stock count accordingly
            stockList.sellStock(item.getKey().getName(), item.getValue());
            System.out.println("Quantity reserved should now be 0: " + item.getKey().getQtyReserved());
        }
        System.out.println(stockList + "\n");
        // Clear basket
        basket.clearBasket();
    }
}
