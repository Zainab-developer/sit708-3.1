package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    EditText firstNumberEditText, secondNumberEditText;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        firstNumberEditText = findViewById(R.id.firstNumberEditText);
        secondNumberEditText = findViewById(R.id.secondNumberEditText);
        resultTextView = findViewById(R.id.resultTextView);
    }

    public void add(View view) {

        String firstNumberStr = firstNumberEditText.getText().toString();
        String secondNumberStr = secondNumberEditText.getText().toString();


        if (!firstNumberStr.isEmpty() && !secondNumberStr.isEmpty()) {

            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);


            double result = firstNumber + secondNumber;

            // Display result
            resultTextView.setText(String.valueOf(result));
        } else {
            // Show error message if any field is empty
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
        }
    }

    public void subtract(View view) {

        String firstNumberStr = firstNumberEditText.getText().toString();
        String secondNumberStr = secondNumberEditText.getText().toString();


        if (!firstNumberStr.isEmpty() && !secondNumberStr.isEmpty()) {

            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);

            //  subtraction
            double result = firstNumber - secondNumber;

            // Display result
            resultTextView.setText(String.valueOf(result));
        } else {

            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
        }
    }
}
