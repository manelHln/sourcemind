package Shop;

import java.util.Random;

public class ProductItem {
    private String productName; // shoe
    private double productPrice; // 34

    private int number;
    private int quantity;

    public ProductItem(String name, double price, int quantity, int number){
        this.quantity = quantity;
        this.productPrice = price * quantity;
        this.number = number;
        this.productName = name;
    }

    public String getName(){
        return this.productName;
    }

    public void setName(String name){
        this.productName = name;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double getPrice(){
        return this.productPrice;
    }

    public void setPrice(double price){
        this.productPrice = price * quantity;
    }
}
