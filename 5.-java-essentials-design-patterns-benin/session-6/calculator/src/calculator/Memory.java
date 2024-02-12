package calculator;

import calculator.button.OperatorButton;

public class Memory {
    private int acc;
    private int curr;
    private OperatorButton operatorButton;

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public int getAcc() {
        return acc;
    }

    public int getCurr() {
        return curr;
    }

    @Override
    public String toString() {
        return "acc=" + acc + ", curr=" + curr;
    }

    public OperatorButton getOperatorButton() {
        return operatorButton;
    }

    public void setOperatorButton(OperatorButton operatorButton) {
        this.operatorButton = operatorButton;
    }
}
