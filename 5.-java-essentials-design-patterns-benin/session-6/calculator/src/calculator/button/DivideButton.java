package calculator.button;

public class DivideButton extends OperatorButton {
    public DivideButton() {
        super("÷");
    }

    @Override
    public int calculate(int acc, int curr) {
        return acc / curr;
    }
}
