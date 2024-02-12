import customer.ShoppingCart;
import payment.CashPayment;
import payment.Payment;
import store.Catalogue;
import store.ProductItem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Catalogue catalogue = new Catalogue();
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner input = new Scanner(System.in);

        while (true) {
            String line = askProduct(input);
            if ("q".equalsIgnoreCase(line)) {
                break;
            }

            int productNumber = Integer.parseInt(line);
            ProductItem product = catalogue.find(productNumber);

            int quantity = askQuantity(input);

            shoppingCart.addItem(product, quantity);

            if (shoppingCart.getSize() == 3) {
                break;
            }
        }

        System.out.println("Total price: " + shoppingCart.getTotal());

        Payment payment = new CashPayment(shoppingCart.getTotal());
        payment.accept(1000);

        if (payment.verify()) {
            System.out.println("Payment is complete, Thank you!");
        } else {
            System.out.println("Payment rejected");
        }
    }

    private static String askProduct(Scanner scanner) {
        System.out.println("Enter product number (q to quit):");
        return scanner.nextLine();
    }

    private static int askQuantity(Scanner scanner) {
        System.out.println("Enter product quantity:");
        return Integer.parseInt(scanner.nextLine());
    }
}