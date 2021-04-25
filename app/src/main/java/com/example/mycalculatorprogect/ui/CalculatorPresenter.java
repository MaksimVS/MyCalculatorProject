package com.example.mycalculatorprogect.ui;

import android.widget.CalendarView;

import com.example.mycalculatorprogect.domain.CalculatorOperations;

public class CalculatorPresenter {

    private CalendarView view;
    private CalculatorOperations calculator;


    public CalculatorPresenter(CalendarView view, CalculatorOperations calculator) {
        this.view = view;
        this.calculator = calculator;
    }
}
}
