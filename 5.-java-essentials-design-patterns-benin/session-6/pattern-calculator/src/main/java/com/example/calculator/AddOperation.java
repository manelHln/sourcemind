package com.example.calculator;

public class AddOperation implements Calculator {

    private static Calculator instance;

    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public float calculate(float num1, float num2) {
        return num1 + num2;
    }

    @Override
    public long calculate(long num1, long num2) {
        return num1 + num2;
    }

    public static Calculator getInstance(){
        if(instance == null){
            instance = new AddOperation();
        }
        return instance;
    }

}
