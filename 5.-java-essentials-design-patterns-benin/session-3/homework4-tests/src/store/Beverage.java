package store;

public class Beverage extends ProductItem {
    public Beverage(int number, String name, double unitPrice, double size) {
        super(number, name, unitPrice, size);
    }

    @Override
    public String getUnitDescription() {
        return "Liter";
    }
}
