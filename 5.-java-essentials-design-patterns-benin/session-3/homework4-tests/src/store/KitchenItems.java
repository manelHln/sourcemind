package store;

public class KitchenItems extends ProductItem {
    public KitchenItems(int number, String name, double unitPrice) {
        super(number, name, unitPrice, 1);
    }

    @Override
    public String getUnitDescription() {
        return "Piece";
    }
}
