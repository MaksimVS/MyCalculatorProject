package com.example.mycalculatorprogect.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

import com.example.mycalculatorprogect.R;
import com.example.mycalculatorprogect.domain.CalculatorImpl;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());
    }

    @Override
    public void showResult(String result) {

    }
}