package com.example.conversion;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import com.example.conversion.models.Grados;
import com.example.conversion.models.Celsius;
import com.example.conversion.models.Fahrenheit;
import com.example.conversion.models.Kelvin;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RadioButton radioButtonFahrenheit;
    private RadioButton radioButtonCelsius;
    private RadioButton radioButtonKelvin;
    private Button button;
    private TextView textViewFahrenheit;
    private TextView textViewCelsius;
    private TextView textViewKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);
        radioButtonFahrenheit = findViewById(R.id.radioButton);
        radioButtonCelsius = findViewById(R.id.radioButton2);
        radioButtonKelvin = findViewById(R.id.radioButton3);
        button = findViewById(R.id.button);
        textViewFahrenheit = findViewById(R.id.fahvalor);
        textViewCelsius = findViewById(R.id.celval);
        textViewKelvin = findViewById(R.id.kelvalor);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioButtonFahrenheit.isChecked()) {
                    textViewFahrenheit.setText(editText.getText());
                    textViewCelsius.setText(Celsius.parse(new Fahrenheit(Double.parseDouble(editText.getText().toString()))).getValor().toString());
                    textViewKelvin.setText(Kelvin.parse(new Fahrenheit(Double.parseDouble(editText.getText().toString()))).getValor().toString());
                } else if (radioButtonCelsius.isChecked()) {
                    textViewFahrenheit.setText(Fahrenheit.parse(new Celsius(Double.parseDouble(editText.getText().toString()))).getValor().toString());
                    textViewCelsius.setText(editText.getText());
                    textViewKelvin.setText(Kelvin.parse(new Celsius(Double.parseDouble(editText.getText().toString()))).getValor().toString());
                } else if (radioButtonKelvin.isChecked()) {
                    textViewFahrenheit.setText(Fahrenheit.parse(new Kelvin(Double.parseDouble(editText.getText().toString()))).getValor().toString());
                    textViewCelsius.setText(Celsius.parse(new Kelvin(Double.parseDouble(editText.getText().toString()))).getValor().toString());
                    textViewKelvin.setText(editText.getText());
                }
                findViewById(R.id.line3).setVisibility(View.VISIBLE);
                findViewById(R.id.line4).setVisibility(View.VISIBLE);
                findViewById(R.id.line5).setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }

    });}
}
