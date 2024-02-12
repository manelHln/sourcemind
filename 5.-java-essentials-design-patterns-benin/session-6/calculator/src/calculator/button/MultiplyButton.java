package calculator.button;

public class MultiplyButton extends OperatorButton {
    public MultiplyButton() {
        super("x");
    }

    @Override
    public int calculate(int acc, int curr) {
        return acc * curr;
    }
}
