import customer.ShoppingCart;
import payment.CardPayment;
import payment.CashPayment;
import payment.Payment;
import store.Catalogue;
import store.ProductItem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Catalogue catalogue = new Catalogue();
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = askProduct(scanner);
            if ("q".equalsIgnoreCase(line)) {
                break;
            }

            int productNumber = Integer.parseInt(line);
            ProductItem product = catalogue.find(productNumber);

            int quantity = askQuantity(scanner);

            shoppingCart.addItem(product, quantity);

            if (shoppingCart.getSize() == 3) {
                break;
            }
        }

        System.out.println("Total price: " + shoppingCart.getTotal());

        System.out.println("Choose payment method:");
        int method = Integer.parseInt(scanner.nextLine());
        Payment payment = null;

        if (method ==  1) {
            payment = new CashPayment(shoppingCart.getTotal());
            System.out.println("Ask for cash:");
            payment.accept(scanner.nextDouble());
        } else if (method ==  2) {
            try {
                payment = new CardPayment(shoppingCart.getTotal(), scanner);
            } catch (Exception e) {
                payment = new CardPayment(shoppingCart.getTotal(), scanner);
            }
            System.out.println("Card payment created.");
        } else {
            System.err.println("Wrong choice");
            System.exit(1);
        }

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