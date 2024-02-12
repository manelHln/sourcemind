package store;

public class Toy extends ProductItem {
    public Toy(int number, String name, double unitPrice) {
        super(number, name, unitPrice, 1);
    }

    @Override
    public String getUnitDescription() {
        return "Box";
    }
}
