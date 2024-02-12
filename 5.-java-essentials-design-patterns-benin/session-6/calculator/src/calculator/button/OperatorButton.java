package calculator.button;

import calculator.Memory;

public abstract class OperatorButton extends Button {

    public OperatorButton(String label) {
        this.label = label;
    }

    @Override
    public void press(Memory memory) {
        OperatorButton previousOperator = memory.getOperatorButton();

        if (previousOperator == null) {
            memory.setAcc(memory.getCurr());
        } else {
            int newValue = previousOperator.calculate(memory.getAcc(), memory.getCurr());
            memory.setAcc(newValue);
        }

        memory.setCurr(0);
        memory.setOperatorButton(this);
    }

    public abstract int calculate(int acc, int curr);
}
