package Shop;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<ProductItem> items = new ArrayList<>();

    public void add(ProductItem item, int howMany) {};
    public double getTotal() {
        double total = 0;
        for (ProductItem item :
                items) {
            total += item.getPrice();
        }
        return total;
    };

    public void addToCart(ProductItem product){
        items.add(product);
    }

    public void getItems(){
        for (ProductItem item :
                items) {
            System.out.println(item.toString());
        }
    }

}
