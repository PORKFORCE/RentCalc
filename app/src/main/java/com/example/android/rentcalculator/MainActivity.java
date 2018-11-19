package com.example.android.rentcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView rentText;
    TextView costPerUnitText;
    private int rent;
    private double costPerUnit, meterReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rentText = (TextView) findViewById(R.id.rent_text);
        costPerUnitText = (TextView) findViewById(R.id.cost_per_unit_text);

    }

    //TODO Delete
    protected void setRent(View view) {
        rent = 500;
        displayRent(rent);
    }

    //TODO Delete
    protected void displayRent(int rentArg) {
        rentText.setText(String.valueOf(rentArg));
    }

    protected void setCostPerUnit(View v) {
        costPerUnit = Double.valueOf(costPerUnitText.getText().toString());
        displayCostPerUnit(costPerUnit);
    }

    protected void displayCostPerUnit(double cpu) {
        costPerUnitText.setText(String.valueOf(costPerUnitText));
    }
}
