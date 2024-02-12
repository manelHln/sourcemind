import calculator.Calculator;
import calculator.validation.WrongInputException;

public class TestApp {
    public static void main(String[] args) {
        test("1+2+3=", 6);
        test("2*3+1=", 7);
        test("200+1=", 201);
    }

    private static void test(String commands, int expected) {

        Calculator calculator = new Calculator();

        for (int i = 0; i < commands.length(); i++) {
            char character = commands.charAt(i);
            try {
                calculator.accept(character);
            } catch (WrongInputException e) {
                System.err.println("Exception thrown: " + e.getMessage());
            }
        }

        int result = calculator.getResult();

        if (result == expected) {
            System.out.println("Test " + commands + " Passed");
        } else {
            System.err.println("Test " + commands + " Failed. Expected " + expected + " but was " + result);
        }
    }
}
