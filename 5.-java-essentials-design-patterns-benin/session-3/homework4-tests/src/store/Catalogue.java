package store;

public class Catalogue {
    private ProductItem[] items;

    public Catalogue() {
        items = new ProductItem[5];
        items[0] = new Sweets(1, "Dark Chocolate", 100, 800);
        items[1] = new Beverage(2, "Red Wine", 200, 0.7);
        items[2] = new Beverage(3, "Beer", 300, 0.5);
        items[3] = new KitchenItems(4, "Mug", 400);
        items[4] = new Toy(5, "Lego Collection", 500);
    }

    public ProductItem find(int number) {
        for (ProductItem item : items) {
            if (number == item.getNumber()) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ProductItem item : items) {
            stringBuilder.append(item.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
