package store;

public class Sweets extends ProductItem {
    public Sweets(int number, String name, double unitPrice, double weight) {
        super(number, name, unitPrice, weight);
    }

    @Override
    public String getUnitDescription() {
        return "Gram";
    }
}
