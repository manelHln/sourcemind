package payment;

public class CashPayment implements Payment {

    private double expected;
    private double received;

    public CashPayment(double expected) {
        this.expected = expected;
    }

    @Override
    public void accept(double amount) {
        this.received = amount;
    }

    @Override
    public boolean verify() {
        if (received < expected) {
            return false;
        }

        double change = received - expected;
        System.out.println("Change to return: " + change);
        return true;
    }
}
