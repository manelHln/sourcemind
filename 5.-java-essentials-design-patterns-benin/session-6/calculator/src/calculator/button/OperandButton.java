package calculator.button;

import calculator.Memory;

public class OperandButton extends Button {

    private int value;

    public OperandButton(int value) {
        this.value = value;
        this.label = String.valueOf(value);
    }

    @Override
    public void press(Memory memory) {
        int currentValue = memory.getCurr();
        int newValue = currentValue * 10 + value;
        memory.setCurr(newValue);
    }
}
