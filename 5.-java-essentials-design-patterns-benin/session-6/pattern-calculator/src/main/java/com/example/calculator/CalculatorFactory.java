package com.example.calculator;

import com.example.exception.UnknownOperationException;

public class CalculatorFactory {

    public Calculator getCalculator(Operation operation) {
        if (operation.equals(Operation.ADDITION)) {
            return AddOperation.getInstance();
        } else if (operation.equals(Operation.SUBTRACTION)) {
            return new SubtractOperation();
        } else if (operation.equals(Operation.MULTIPLICATION)) {
            return new MultiplyOperation();
        } else if (operation.equals(Operation.DIVISION)) {
            return new DivideOperation();
        } else {
            throw new UnknownOperationException("Unknown operation");
        }
    }

    public Calculator getCalculator(String operation) {
        try {
            Operation op = Operation.valueOf(operation.toUpperCase());
            return getCalculator(op);
        } catch (IllegalArgumentException ex) {
            throw new UnknownOperationException("Unknown operation");
        }
    }

}
