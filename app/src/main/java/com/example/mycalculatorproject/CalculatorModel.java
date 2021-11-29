package com.example.mycalculatorproject;

import android.os.Parcel;
import android.os.Parcelable;

public class CalculatorModel implements Parcelable {

    private double arg1;
    private double arg2;

    private StringBuilder inputString = new StringBuilder();
    private int OperandSelected;

    private State state;

    protected CalculatorModel(Parcel in) {
        arg1 = in.readDouble();
        arg2 = in.readDouble();
        OperandSelected = in.readInt();
    }

    public static final Creator<CalculatorModel> CREATOR = new Creator<CalculatorModel>() {
        @Override
        public CalculatorModel createFromParcel(Parcel in) {
            return new CalculatorModel(in);
        }

        @Override
        public CalculatorModel[] newArray(int size) {
            return new CalculatorModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(arg1);
        parcel.writeDouble(arg2);
        parcel.writeInt(OperandSelected);
    }

    private enum State {
        arg1_input,
        arg2_input,
        resultShow
    }

    public CalculatorModel() {
        state = State.arg1_input;
    }

    public void onNumButtonPress(int numButton_Id) {
        if (state == State.resultShow) {
            state = State.arg1_input;
            arg1 = Double.parseDouble(inputString.toString());
            inputString.setLength(0);
            state = State.arg2_input;
        }

        if (inputString.length() < 9) {
            switch (numButton_Id) {
                case R.id.btn_dot:
                    inputString.append(".");
                    break;
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
            arg2 = Double.parseDouble(inputString.toString());
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
            arg1 = Double.parseDouble(inputString.toString());
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
        }
    }

    public void onAdditionButtonPress(int addButton_Id) {
        if (addButton_Id == R.id.btn_delete && inputString.length() > 0 && state == State.arg1_input) {
            inputString = inputString.deleteCharAt(inputString.length() - 1);
            state = State.arg1_input;
        } else if (addButton_Id == R.id.btn_delete && inputString.length() > 0 && state == State.arg2_input) {
            inputString = inputString.deleteCharAt(inputString.length() - 1);
            state = State.arg2_input;
        } else if (addButton_Id == R.id.btn_nullify) {
            inputString.setLength(0);
            state = State.arg1_input;
        }
    }

    public String getText() {
        return inputString.toString();
    }
}
