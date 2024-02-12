import Shop.ProductItem;
import Shop.ShoppingCart;
import Shop.Checkout;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart userCart = new ShoppingCart();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the checkout! Enter the product data to complete the checkout.");
        boolean keepAdding = true;
        do {
            System.out.println("Enter product name (q to quit):");
            String name = userInput.nextLine();
            if (name.equals("q")) {
                keepAdding = false;
                break;
            }
            System.out.println("Enter product price (q to quit):");
            String priceInput = userInput.nextLine();
            if (priceInput.equals("q")) {
                keepAdding = false;
                break;
            }
            double price = Double.parseDouble(priceInput);

            System.out.println("Enter product quantity (q to quit):");
            String qtyInput = userInput.nextLine();
            if (qtyInput.equals("q")) {
                keepAdding = false;
                break;
            }
            int qty = Integer.parseInt(qtyInput);

            Random number = new Random();
            ProductItem item = new ProductItem(name, price, qty, number.nextInt());
            userCart.addToCart(item);
            System.out.println("Product added successfully!");
        } while (keepAdding);
        System.out.printf("The total price is %f \n", userCart.getTotal());
    Checkout UserCheckout = new Checkout();
    UserCheckout.accept(userCart.getTotal());
    }
}
