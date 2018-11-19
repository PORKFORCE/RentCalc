package com.example.android.rentcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double meterUnits;
    private double unitCost;

    //First line
    private EditText mMeterReadingText;
    private TextView mMeterReadingResult;

    //Second line
    private EditText mCostPerUnitText;
    private TextView mCostPerUnitResult;

    private Button bCalculateElectric;

    String unitsString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMeterReadingText = (EditText) findViewById(R.id.meter_reading);
        mMeterReadingResult = (TextView) findViewById(R.id.meter_units);

        mCostPerUnitText = (EditText) findViewById(R.id.cost_per_unit);
        mCostPerUnitResult = (TextView) findViewById(R.id.euro_per_unit);

        bCalculateElectric = (Button) findViewById(R.id.calculate_electricity);

        unitsString = mMeterReadingText.toString();
        //meterUnits = Double.valueOf(unitsString);
        //mMeterReadingResult.setText(unitsString);


    }


}
