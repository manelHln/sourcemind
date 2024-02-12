package store;

public class Catalogue {
    private ProductItem[] items;

    public Catalogue() {
        items = new ProductItem[5];
        items[0] = new ProductItem(1, "Dark Chocolate", 100);
        items[1] = new ProductItem(2, "Red Wine", 200);
        items[2] = new ProductItem(3, "Coffee", 300);
        items[3] = new ProductItem(4, "Mug", 400);
        items[4] = new ProductItem(5, "Lego Collection", 500);
    }

    public ProductItem find(int number) {
        for (ProductItem item : items) {
            if (number == item.getNumber()) {
                return item;
            }
        }
        return null;
    }
}
