public class StockItem implements Comparable<StockItem>{

    private final String name;
    private double price;
    private int qtyInStock;
    private int qtyReserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.qtyInStock = 0;
    }

    public StockItem(String name, double price, int qtyStock) {
        this.name = name;
        this.price = price;
        this.qtyInStock = qtyStock;
    }

    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        }
    }

    public void reserveStockOfItem(int qty) {
        if (qty <= qtyInStock) {
            this.qtyReserved += qty;
        }
    }

    public void unreserveStockOfItem(int qty) {
        if (qty <= qtyReserved) {
            this.qtyReserved -= qty;
        }
    }
    public void adjustStock(int qty) {
        int newQty = this.qtyInStock + qty;
        if (newQty >= 0) {
            this.qtyInStock = newQty;
            this.qtyReserved += qty;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock - qtyReserved;
    }

    public int getQtyReserved() {
        return qtyReserved;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj == this) return true;

        if (obj == null || obj.getClass() != this.getClass()) return false;

        return this.name.equals(((StockItem) obj).getName());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
//        System.out.println("Entering StockItem.compareTo");
        if (this == o) return 0;

        if (o != null) return this.name.compareTo(o.getName());

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": price = £" + String.format("%.2f", this.price);
    }
}
