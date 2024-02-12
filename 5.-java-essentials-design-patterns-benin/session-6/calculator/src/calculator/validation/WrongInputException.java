package calculator.validation;

public class WrongInputException extends Exception {
    public WrongInputException() {
        super("Wrong input");
    }
}
