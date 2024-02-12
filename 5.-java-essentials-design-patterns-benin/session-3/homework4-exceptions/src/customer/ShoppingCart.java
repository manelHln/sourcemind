package customer;

import store.ProductItem;

public class ShoppingCart {
    private ProductItem[] items;
    private int[] quantity;
    private int current;

    public ShoppingCart() {
        items = new ProductItem[3];
        quantity = new int[3];
        current = 0;
    }

    public void addItem(ProductItem item, int howMany) {
        if (current == items.length) {
            return;
        }

        items[current] = item;
        quantity[current] = howMany;
        current++;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < current; i++) {
            total += items[i].getUnitPrice() * quantity[i];
        }
        return total;
    }

    public int getSize() {
        return current;
    }
}
