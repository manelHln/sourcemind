package payment;

public class CardPayment implements Payment {
    @Override
    public void accept(double amount) {

    }

    @Override
    public boolean verify() {
        return false;
    }
}
