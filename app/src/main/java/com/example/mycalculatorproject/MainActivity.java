package com.example.mycalculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private CalculatorModel calculator;
    private TextView textValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] Operand_id = new int[]{
                R.id.btn_plus,
                R.id.btn_minus,
                R.id.btn_multiplication,
                R.id.btn_division,
                R.id.btn_equally
        };

        int[] AddButton_id = new int[]{
                R.id.btn_nullify,
                R.id.btn_delete
        };

        int[] NumButton_id = new int[]{
                R.id.btn_dot,
                R.id.btn_1,
                R.id.btn_2,
                R.id.btn_3,
                R.id.btn_4,
                R.id.btn_5,
                R.id.btn_6,
                R.id.btn_7,
                R.id.btn_8,
                R.id.btn_9,
                R.id.btn_0,
                R.id.btn_00
        };

        textValue = findViewById(R.id.textValue);
        calculator = new CalculatorModel();

        View.OnClickListener NumButtonClickListener = v -> {
            calculator.onNumButtonPress(v.getId());
            textValue.setText(calculator.getText());
        };

        View.OnClickListener OperandClickListener = v -> {
            calculator.onOperandPress(v.getId());
            textValue.setText(calculator.getText());
        };

        View.OnClickListener AddButtonClickListener = v -> {
            calculator.onAdditionButtonPress(v.getId());
            textValue.setText(calculator.getText());
        };

        for (int value : NumButton_id) {
            findViewById(value).setOnClickListener(NumButtonClickListener);
        }
        for (int i = 0; i < Operand_id.length; i++) {
            findViewById(Operand_id[i]).setOnClickListener(OperandClickListener);
        }

        for (int i = 0; i < AddButton_id.length; i++) {
            findViewById(AddButton_id[i]).setOnClickListener(AddButtonClickListener);
        }


    }
}