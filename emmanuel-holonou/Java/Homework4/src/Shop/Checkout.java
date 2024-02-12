package Shop;

import java.util.Scanner;

public class Checkout implements Payment {
    String accountNumber;

    protected void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    @Override
    public void accept(double amount) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose the payment type: (1: credit card, 2: cash)");
        int paymentType = userInput.nextInt();
        switch (paymentType) {
            case 1 -> {
                System.out.println("Enter the account number");
                String accountNumber = userInput.nextLine();
                this.setAccountNumber(accountNumber);
                if (verify()) {
                    System.out.printf("Successfully debited %f from your account number %s \n", amount, accountNumber);
                    System.out.println("Thank you!!");
                }
            }
            case 2 -> System.out.println("Thank you!!");
            default -> System.out.println("You should choose a valid payment method!!");
        }
    }

    @Override
    public boolean verify() {
//        if(this.accountNumber != null){
//            return false;
//        }
        return true;
    }
}
