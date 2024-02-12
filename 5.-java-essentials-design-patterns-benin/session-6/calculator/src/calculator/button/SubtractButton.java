package calculator.button;

public class SubtractButton extends OperatorButton {
    public SubtractButton() {
        super("-");
    }

    @Override
    public int calculate(int acc, int curr) {
        return acc - curr;
    }
}
