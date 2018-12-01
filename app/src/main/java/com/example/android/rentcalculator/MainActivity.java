package com.example.android.rentcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView rentText;
    TextView costPerUnitText;
    TextView meterReadingText;

    private int rent = 500;
    private double costPerUnit = 0.0, meterReading = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rentText = findViewById(R.id.rent_text);
        costPerUnitText = findViewById(R.id.cost_per_unit_text);
        meterReadingText = findViewById(R.id.meter_reading_text);

    }

    //TODO 1)Change IMEOptions from Go to Send
    //TODO 2)Center text app name
    //TODO 3)Set app icon and add to menu bar
    //TODO 4) Java docs for all set and display methods.
    //TODO 5) Begin new Launch screen activity

    //  RENT METHODS
    protected void setRent(View v) {
        final EditText et = findViewById(R.id.rent_EditText);
        et.addTextChangedListener(new TextWatcher() {
            boolean ignore = false;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ignore) return; // prevents recursive call when setText is called below
                ignore = true;
                String output = et.getText().toString();
                Log.e("MainActivity", "Rent = " + output);
                rentText.setText(output);
                ignore = false;
            }
        });

        try {
            rent = Integer.valueOf(et.getText().toString());
            Log.e("Rent", "Displaying rent value of : " + Integer.valueOf(et.getText().toString()));
        } catch (NumberFormatException E) {
            Log.e("RENT CALCULATION ERROR", "No value added for rent");
        }
        displayRent(rent);
    }

    protected void displayRent(int rent) {
        rentText.setText(String.valueOf(rent));
    }

    //  COST PER UNIT METHODS
    protected void setCostPerUnit(View v) {
        final EditText et = findViewById(R.id.cost_per_unit_editText);
        et.addTextChangedListener(new TextWatcher() {
            boolean ignore = false;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ignore) return;
                ignore = true;
                String output = et.getText().toString();
                Log.e("MainActivity", "Cost per unit = " + output);
                costPerUnitText.setText(output);
                ignore = false;
            }
        });

        try {
            costPerUnit = Double.valueOf(et.getText().toString());
            Log.e("CostPerUnit", "Displaying cost per unit value of : " + Double.valueOf(et.getText().toString()));
        } catch (NumberFormatException E) {
            Log.e("RENT CALCULATION ERROR", "No value added for CPU");
        }
        displayCostPerUnit(costPerUnit);
    }
    protected void displayCostPerUnit(double cpu) {
        costPerUnitText.setText(String.valueOf(cpu));
    }

    //  METER READING METHODS
    protected void setMeterReading(View v) {
        final EditText et = findViewById(R.id.meter_reading_EditText);
        et.addTextChangedListener(new TextWatcher() {
            boolean ignore = false;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ignore) return; // prevents recursive call when setText is called below
                ignore = true;
                String output = et.getText().toString();
                Log.e("MainActivity", "Meter reading = " + output);
                meterReadingText.setText(output);
                ignore = false;
            }
        });

        try {
            meterReading = Double.valueOf(et.getText().toString());
            Log.e("Meter", "Displaying meter reading value of : " + Double.valueOf(et.getText().toString()));
        } catch (NumberFormatException E) {
            Log.e("RENT CALCULATION ERROR", "No value added for meter");
        }
        displayMeterReading(meterReading);
    }

    protected void displayMeterReading(double meter) {
        meterReadingText.setText(String.valueOf(meter));
    }

    protected void calculateRent(View view) {
        Log.e("RentCalculation", "Rent is: Rent(" + rent + ")  + "
                + " Meter Reading(" + meterReading + ")"
                + " times CostPer Unit(" + costPerUnit + ")"
                + " which equals: €" + (rent + (costPerUnit * meterReading)));
        double totalRent = rent + (costPerUnit * meterReading);
        displayTotalPrice(totalRent);

    }

    /**
     * Displays at the bottom of the app the total due by the tenant.
     *
     * @param total The final price calculated in calculateRent
     */
    protected void displayTotalPrice(double total) {
        TextView totalText = findViewById(R.id.total_rent_text);
        totalText.setText("€" + String.valueOf(total));
    }
}
