package store;

public class ProductItem {
    private int number;
    private String name;
    private double unitPrice;

    public ProductItem(int number, String name, double unitPrice) {
        this.number = number;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // Maybe package-private?
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
