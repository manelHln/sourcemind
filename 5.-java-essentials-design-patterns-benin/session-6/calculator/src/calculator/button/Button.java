package calculator.button;

import calculator.Memory;

public abstract class Button {
    protected String label;
    public abstract void press(Memory calculator);

    @Override
    public String toString() {
        return "| " + label + " |";
    }
}
