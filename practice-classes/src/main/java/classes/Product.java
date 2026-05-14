package classes;

public class Product {
    private String productName;
    private boolean isAvailable;
    private long stockCount;

    public Product(String productName, boolean isAvailable, long stockCount) {
        this.productName = productName;
        this.isAvailable = isAvailable;
        this.stockCount = stockCount;
    }

    public void sellItem(long quantity) {
        if (quantity > this.stockCount) {
            throw new RuntimeException("Not enough stock for " + this.productName);
        }

        if (this.isAvailable) {
            this.stockCount = this.stockCount - quantity;
            System.out.println("Sold " + quantity + " units of " + this.productName);

            if (this.stockCount == 0) {
                this.isAvailable = false;
            }
        } else {
            System.out.println(this.productName + " is currently out of stock!");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", isAvailable=" + isAvailable +
                ", stockCount=" + stockCount +
                '}';
    }
}
