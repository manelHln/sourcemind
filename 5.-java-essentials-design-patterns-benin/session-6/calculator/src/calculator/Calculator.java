package calculator;

import calculator.button.AddButton;
import calculator.button.Button;
import calculator.button.DivideButton;
import calculator.button.EqualityButton;
import calculator.button.MultiplyButton;
import calculator.button.OperandButton;
import calculator.button.SubtractButton;
import calculator.validation.WrongInputException;

import java.util.Scanner;

public class Calculator {

    private final Button[] buttons;
    private final Memory memory;

    public Calculator() {
        buttons = new Button[15];
        for (int i = 0; i < 10; i++) {
            buttons[i] = new OperandButton(i);
        }

        buttons[10] = new AddButton();
        buttons[11] = new SubtractButton();
        buttons[12] = new MultiplyButton();
        buttons[13] = new DivideButton();
        buttons[14] = new EqualityButton();

        memory = new Memory();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.print(this);
                char input = askInput(scanner);
                accept(input);

                if (input == '=') {
                    break;
                }
            }
        } catch (WrongInputException e) {
            System.out.println("Terminating due to invalid input.");
            this.memory.setAcc(0);
            this.memory.setCurr(0);
        } finally {
            stop();
        }
    }

    public void stop() {
        System.out.println("Result: " + getResult());
        System.out.println("Exiting calculator app...");
        System.exit(0);
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < buttons.length; i++) {
            str = str.concat(buttons[i].toString());

            if ((i+1) % 3 == 0) {
                str = str.concat("\n");
            }
        }

        str = str.concat("\n")
                .concat(memory.toString()).concat("\n")
                .concat("---------------------\n");

        return str;
    }

    public char askInput(Scanner scanner) throws WrongInputException {
        System.out.print("Choose button: ");
        String str = scanner.next();

        // Validate input
        if (str.length() != 1) {
            throw new WrongInputException();
        }

        return str.charAt(0);
    }

    public void accept(char label) throws WrongInputException {

        Button pressedButton = null;

        // Handle digit input
        if (Character.isDigit(label)) {
            int index = Character.getNumericValue(label);
            pressedButton = buttons[index];
        }

        // Handle operation input
        if (label == '+') {
            pressedButton = buttons[10];
        } else if (label == '-') {
            pressedButton = buttons[11];
        } else if (label == '*') {
            pressedButton = buttons[12];
        } else if (label == '/') {
            pressedButton = buttons[13];
        } else if (label == '=') {
            pressedButton = buttons[14];
        }

        // Could not map input to a button, this is an error
        if (pressedButton == null) {
            throw new WrongInputException();
        }

        pressedButton.press(memory);
    }

    public int getResult() {
        return memory.getAcc();
    }
}
