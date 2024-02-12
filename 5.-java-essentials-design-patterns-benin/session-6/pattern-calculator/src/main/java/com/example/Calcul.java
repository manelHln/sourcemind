package com.example;

import com.example.calculator.Calculator;
import com.example.calculator.CalculatorFactory;
import com.example.calculator.Operation;

public class Calcul {
    public static void main(String[] args) {
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        Calculator calculator;

        calculator = calculatorFactory.getCalculator(Operation.ADDITION);
        System.out.println("R: " + calculator.calculate(17, 31));

        calculator = calculatorFactory.getCalculator(Operation.SUBTRACTION);
        System.out.println("R: " + calculator.calculate(45, 27));

        calculator = calculatorFactory.getCalculator(Operation.MULTIPLICATION);
        System.out.println("R: " + calculator.calculate(10, 11));

        calculator = calculatorFactory.getCalculator(Operation.DIVISION);
        System.out.println("R: " + calculator.calculate(9.0, 2));


    }
}
