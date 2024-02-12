package store;

public abstract class ProductItem {
    private int number;
    private String name;
    private double unitPrice;

    private double size;

    public ProductItem(int number, String name, double unitPrice, double size) {
        this.number = number;
        this.name = name;
        this.unitPrice = unitPrice;
        this.size = size;
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

    public abstract String getUnitDescription();

    @Override
    public String toString() {
        return name + " " + size + " (" + getUnitDescription() + " )";
    }
}
