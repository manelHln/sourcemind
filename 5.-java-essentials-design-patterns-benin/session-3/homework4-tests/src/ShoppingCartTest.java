import customer.ShoppingCart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import store.Beverage;
import store.ProductItem;

public class ShoppingCartTest {

    private ProductItem item1;
    private ProductItem item2;

    @Before
    public void setup() {
        item1 = new Beverage(1, "Beer", 100, 0.5);
        item2 = new Beverage(2, "Wine", 200, 0.7);
    }

    @Test
    public void testTotal() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(item1, 1);
        shoppingCart.addItem(item2, 2);

        double total = shoppingCart.getTotal();
        Assert.assertEquals(500, total, 0.00000001);
    }

    @Test
    public void testSize() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(item1, 1);
        shoppingCart.addItem(item2, 2);

        Assert.assertEquals(2, shoppingCart.getSize());
    }
}
