package Shop;

public interface Payment {
    void accept(double amount);
    boolean verify();
}