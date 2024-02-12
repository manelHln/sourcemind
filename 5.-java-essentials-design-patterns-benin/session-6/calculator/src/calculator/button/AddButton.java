package calculator.button;

public class AddButton extends OperatorButton {
    public AddButton() {
        super("+");
    }

    @Override
    public int calculate(int acc, int curr) {
        return acc + curr;
    }
}
