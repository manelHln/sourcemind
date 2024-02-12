//import calculator.Calculator;
//import calculator.button.AddButton;
//import calculator.validation.WrongInputException;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Scanner;
//
//public class CalculatorTest {
//
//    private Calculator calculator;
//
//    @Before
//    public void setup() {
//        calculator = new Calculator();
//    }
//
//    @Test
//    public void testAdd() throws WrongInputException {
//        calculator.accept('1');
//        calculator.accept('+');
//        calculator.accept('1');
//        calculator.accept('=');
//
//        Assert.assertEquals("Strange math",
//                2, calculator.getResult());
//    }
//
//    @Test
//    public void testSubtract() throws WrongInputException {
//        Calculator calculator = new Calculator();
//        calculator.accept('1');
//        calculator.accept('-');
//        calculator.accept('1');
//        calculator.accept('=');
//
//        Assert.assertEquals(0, calculator.getResult());
//    }
//
//    @Test
//    public void testAddButton() {
//        AddButton button = new AddButton();
//        Assert.assertEquals(2, button.calculate(1, 1));
//    }
//
//    @Test
//    public void testWrongInput() {
//        try {
//            calculator.accept('a');
//            Assert.fail("Should have thrown exception");
//        } catch (WrongInputException e) {
//            Assert.assertEquals("Wrong input", e.getMessage());
//        }
//    }
//
//    @Test
//    public void testAskInput() {
//        Scanner testScanner = new Scanner("1");
//        try {
//            char ch = calculator.askInput(testScanner);
//            Assert.assertEquals('1', ch);
//        } catch (WrongInputException e) {
//            Assert.fail();
//        }
//
//        testScanner = new Scanner("+");
//        try {
//            char ch = calculator.askInput(testScanner);
//            Assert.assertEquals('+', ch);
//        } catch (WrongInputException e) {
//            Assert.fail();
//        }
//
//        testScanner = new Scanner("++");
//        try {
//            calculator.askInput(testScanner);
//            Assert.fail("Should have thrown exception");
//        } catch (WrongInputException e) {
//            Assert.assertEquals("Wrong input", e.getMessage());
//        }
//    }
//}
