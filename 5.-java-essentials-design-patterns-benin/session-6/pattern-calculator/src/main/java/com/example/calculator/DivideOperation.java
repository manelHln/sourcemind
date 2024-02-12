package com.example.calculator;

import com.example.exception.InvalidArgumentException;

public class DivideOperation implements Calculator {

    @Override
    public double calculate(double num1, double num2) {
        if (num2 == 0.0) {
            throw new InvalidArgumentException("The second argument must not be zero");
        }
        return num1 / num2;
    }

    @Override
    public int calculate(int num1, int num2) {
        if (num2 == 0) {
            throw new InvalidArgumentException("The second argument must not be zero");
        }
        return num1 / num2;
    }

    @Override
    public float calculate(float num1, float num2) {
        if (num2 == 0.0f) {
            throw new InvalidArgumentException("The second argument must not be zero");
        }
        return num1 / num2;
    }

    @Override
    public long calculate(long num1, long num2) {
        if (num2 == 0l) {
            throw new InvalidArgumentException("The second argument must not be zero");
        }
        return num1 / num2;
    }
}
