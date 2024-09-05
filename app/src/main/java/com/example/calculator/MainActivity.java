package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCelsius;
    private TextView textViewFahrenheit, textViewKelvin, textViewMessage;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        textViewFahrenheit = findViewById(R.id.textViewFahrenheit);
        textViewKelvin = findViewById(R.id.textViewKelvin);
        textViewMessage = findViewById(R.id.textViewMessage);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusInput = editTextCelsius.getText().toString();

                if (!celsiusInput.isEmpty()) {
                    double celsius = Double.parseDouble(celsiusInput);

                    double fahrenheit = (celsius * 9 / 5) + 32;
                    double kelvin = celsius + 273.15;

                    textViewFahrenheit.setText(String.format("%.1f F", fahrenheit));
                    textViewKelvin.setText(String.format("%.2f K", kelvin));

                    if (celsius < 0) {
                        textViewMessage.setText("It's Freezing");
                    } else if (celsius >= 0 && celsius < 18) {
                        textViewMessage.setText("It's Cold");
                    } else if (celsius >=18 && celsius <28) {
                        textViewMessage.setText("It's Warm");
                    } else {
                        textViewMessage.setText("It's Hot");
                    }
                }
            }
        });
    }
}
