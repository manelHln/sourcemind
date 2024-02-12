import calculator.Calculator;
import calculator.validation.WrongInputException;

public class Main {

    public static void main(String[] args) throws WrongInputException {
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
