package calculator.button;

import calculator.Memory;

public class EqualityButton extends OperatorButton {
    public EqualityButton() {
        super("=");
    }

    @Override
    public int calculate(int acc, int curr) {
        return acc;
    }
}
