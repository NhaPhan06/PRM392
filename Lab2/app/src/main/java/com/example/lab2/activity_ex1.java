package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class activity_ex1 extends AppCompatActivity {
    Button back;
    private EditText editTextNumberMin;
    private EditText editTextNumberMax;
    private Button btnGenerate;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editTextNumberMin = findViewById(R.id.editTextNumberMin);
        editTextNumberMax = findViewById(R.id.editTextNumberMax);
        btnGenerate = findViewById(R.id.btnGenerate);
        textViewResult = findViewById(R.id.textViewResult);

        btnGenerate.setOnClickListener(v -> {
            try {
                boolean isValid = true;
                String minStr = editTextNumberMin.getText().toString();
                String maxStr = editTextNumberMax.getText().toString();
                if (minStr.trim().isEmpty()) {
                    editTextNumberMin.setError("Please enter a number");
                    isValid = false;
                }
                if (maxStr.trim().isEmpty()) {
                    editTextNumberMax.setError("Please enter a number");
                    isValid = false;
                }
                if (!isValid) {
                    return;
                }
                int min = Integer.parseInt(minStr);
                int max = Integer.parseInt(maxStr);
                if (min >= max) {
                    Toast.makeText(this, "Max number must be greater than the min one.", Toast.LENGTH_SHORT).show();
                } else {
                    Random random = new Random();
                    int result = random.nextInt(max - min + 1) + min;
                    textViewResult.setText("Result: " + result);
                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        setContentView(R.layout.activity_ex1);
        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(view -> {
            Intent intent = new Intent();
            startActivity(intent);
        });
    }
}