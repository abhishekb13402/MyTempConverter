package com.example.mytempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextCelsius;
    EditText editTextFahrenheit;
    Button buttonCelsiusToFahrenheit;
    Button buttonFahrenheitToCelsius;
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        buttonCelsiusToFahrenheit = findViewById(R.id.buttonCelsiusToFahrenheit);
        buttonFahrenheitToCelsius = findViewById(R.id.buttonFahrenheitToCelsius);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCelsiusToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCelsiusToFahrenheit();
            }
        });

        buttonFahrenheitToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertFahrenheitToCelsius();
            }
        });
        
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    private void convertCelsiusToFahrenheit() {
        try {
            double celsius = Double.parseDouble(editTextCelsius.getText().toString());
            double fahrenheit = (celsius * 9 / 5) + 32;

            editTextFahrenheit.setText(String.format("%.2f", fahrenheit));
            textViewResult.setText(String.format("%.2f°C is equal to %.2f°F", celsius, fahrenheit));
        } catch (NumberFormatException e) {
            textViewResult.setText("Please enter a valid temperature in Celsius.");
        }
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    private void convertFahrenheitToCelsius() {
        try {
            double fahrenheit = Double.parseDouble(editTextFahrenheit.getText().toString());
            double celsius = (fahrenheit - 32) * 5 / 9;

            editTextCelsius.setText(String.format("%.2f", celsius));
            textViewResult.setText(String.format("%.2f°F is equal to %.2f°C", fahrenheit, celsius));
        } catch (NumberFormatException e) {
            textViewResult.setText("Please enter a valid temperature in Fahrenheit.");
        }
    }
}