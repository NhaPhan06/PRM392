package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;

    TextView textView;
    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.editTextFirstNumber);
        secondNumber = findViewById(R.id.editTextSecondNumber);
        textView = findViewById(R.id.textResult);
        btnDiv = findViewById(R.id.btnDivision);
        btnAdd = findViewById(R.id.btnAddition);
        btnMul = findViewById(R.id.btnMultiplication);
        btnSub = findViewById(R.id.btnSubtraction);

        int first = Integer.parseInt(firstNumber.getText().toString());
        int second = Integer.parseInt(secondNumber.getText().toString());

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(first - second);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(first + second);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(first*second);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(first/second);
            }
        });

    }
}