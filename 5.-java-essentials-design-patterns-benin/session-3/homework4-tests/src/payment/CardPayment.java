package payment;

import java.util.Scanner;

public class CardPayment implements Payment {
    private double expected;
    private Scanner scanner;
    private String cardNumber;

    public CardPayment(double expected, Scanner scanner) throws Exception {
        this.expected = expected;
        this.scanner = scanner;

        String cardNumber = scanner.nextLine();
        // Validate cardNumber
        if (!checkCardNumber(cardNumber)) {
            throw new Exception("Invalid card number");
        }

        this.cardNumber = cardNumber;
    }

    @Override
    public void accept(double amount) {
        System.out.println("Enter the card number:");
    }

    @Override
    public boolean verify() {
        return getBalance(cardNumber) >= expected;
    }

    private static boolean checkCardNumber(String cardNumber) {
        if (cardNumber.length() != 16) {
            return false;
        }

        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static double getBalance(String cardNumber) {
        // In real world this should get from the bank service
        return 1000;
    }
}
