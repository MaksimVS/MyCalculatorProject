package com.example.mycalculatorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private CalculatorModel calculatorModel;
    private TextView textValue;
    private static final String ARG_KEY = "ARG_KEY";

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

        if (savedInstanceState != null){
            calculatorModel = savedInstanceState.getParcelable(ARG_KEY);
        }

        textValue = findViewById(R.id.textValue);
        calculatorModel = new CalculatorModel();
        textValue.setText(String.valueOf(calculatorModel.getText()));

        View.OnClickListener NumButtonClickListener = v -> {
            calculatorModel.onNumButtonPress(v.getId());
            textValue.setText(calculatorModel.getText());
        };

        View.OnClickListener OperandClickListener = v -> {
            calculatorModel.onOperandPress(v.getId());
            textValue.setText(calculatorModel.getText());
        };

        View.OnClickListener AddButtonClickListener = v -> {
            calculatorModel.onAdditionButtonPress(v.getId());
            textValue.setText(calculatorModel.getText());
        };

        for (int value : NumButton_id) {
            findViewById(value).setOnClickListener(NumButtonClickListener);
        }
        for (int j : Operand_id) {
            findViewById(j).setOnClickListener(OperandClickListener);
        }

        for (int j : AddButton_id) {
            findViewById(j).setOnClickListener(AddButtonClickListener);
        }

        findViewById(R.id.textValue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textValue.setText(String.valueOf(calculatorModel.getText()));
            }
        });
    }
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putParcelable(ARG_KEY,calculatorModel);
    }
}