package com.example.exercise1dungvuong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.exercise1dungvuong.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button.setOnClickListener(this::onClick);
    }
    public void onClick(View view) {
        // Toast a message for empty entry
        if (binding.textView.getText().length() == 0) {
            Toast.makeText(this, "Please enter a valid number",
                    Toast.LENGTH_LONG).show();
            return;
        }
        // Get the input value from the text box
        float inputValue =
                Float.parseFloat(binding.textView.getText().toString());
        if (binding.radioButton.isChecked()) {
            // Set the text box to be the result of conversion
            binding.textView.setText(String.valueOf(ConverterUtil.
                    convertFahrenheitToCelsius(inputValue)));
            // Switch to the other option
            binding.radioButton.setChecked(false);
            binding.radioButton1.setChecked(true);
        } else {
            binding.textView.setText(String.valueOf(ConverterUtil.
                    convertCelsiusToFahrenheit(inputValue)));
            binding.radioButton1.setChecked(false);
            binding.radioButton.setChecked(true);
        }
    }

}