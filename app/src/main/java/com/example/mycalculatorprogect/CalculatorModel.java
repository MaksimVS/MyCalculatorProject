package com.example.mycalculatorprogect;

public class CalculatorModel {

    private double arg1;
    private double arg2;

    private StringBuilder inputString = new StringBuilder();
    private int OperandSelected;

    private State state;

    private enum State {
        arg1_input,
        arg2_input,
        resultShow
    }

    public CalculatorModel() {
        state = State.arg1_input;
    }

    public void onNumButtonPress(int button_Id) {
        if (state == State.resultShow) {
            state = State.arg1_input;
            inputString.setLength(0);
        }

        if (inputString.length() < 9) {
            switch (button_Id) {
                case R.id.btn_0:
                    if (inputString.length() != 0) {
                        inputString.append("0");
                    }
                    break;
                case R.id.btn_00:
                    if (inputString.length() != 0) {
                        inputString.append("00");
                    }
                    break;
                case R.id.btn_1:
                    inputString.append("1");
                    break;
                case R.id.btn_2:
                    inputString.append("2");
                    break;
                case R.id.btn_3:
                    inputString.append("3");
                    break;
                case R.id.btn_4:
                    inputString.append("4");
                    break;
                case R.id.btn_5:
                    inputString.append("5");
                    break;
                case R.id.btn_6:
                    inputString.append("6");
                    break;
                case R.id.btn_7:
                    inputString.append("7");
                    break;
                case R.id.btn_8:
                    inputString.append("8");
                    break;
                case R.id.btn_9:
                    inputString.append("9");
                    break;
            }
        }
    }

    public void onOperandPress(int operand_Id) {
        if (operand_Id == R.id.btn_equally && state == State.arg2_input) {
            arg2 = Integer.parseInt(inputString.toString());
            state = State.resultShow;
            inputString.setLength(0);
            switch (OperandSelected) {
                case R.id.btn_division:
                    inputString.append(arg1 / arg2);
                    break;
                case R.id.btn_minus:
                    inputString.append(arg1 - arg2);
                    break;
                case R.id.btn_multiplication:
                    inputString.append(arg1 * arg2);
                    break;
                case R.id.btn_plus:
                    inputString.append(arg1 + arg2);
                    break;
            }
        } else if (inputString.length() > 0 && state == State.arg1_input) {
            arg1 = Integer.parseInt(inputString.toString());
            state = State.arg2_input;
            inputString.setLength(0);
        }

        switch (operand_Id) {
            case R.id.btn_division:
                OperandSelected = R.id.btn_division;
                break;
            case R.id.btn_minus:
                OperandSelected = R.id.btn_minus;
                break;
            case R.id.btn_multiplication:
                OperandSelected = R.id.btn_multiplication;
                break;
            case R.id.btn_plus:
                OperandSelected = R.id.btn_plus;
                break;
            case R.id.btn_equally:
                OperandSelected = R.id.btn_equally;
                break;

           /* case R.id.btn_delete:
                OperandSelected = R.id.btn_delete;
                break;
            case R.id.btn_dot:
                OperandSelected = R.id.btn_dot;
                break;
            case R.id.btn_nullify:
                OperandSelected = R.id.btn_nullify;
                break;*/
        }
    }

    public String getText() {
        return inputString.toString();
    }
}