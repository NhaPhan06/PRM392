package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_ex2 extends AppCompatActivity {
    Button back;
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
        setContentView(R.layout.activity_ex2);

        back = (Button) findViewById(R.id.back);
        firstNumber = findViewById(R.id.editTextFirstNumber);
        secondNumber = findViewById(R.id.editTextSecondNumber);
        textView = findViewById(R.id.textResult);
        btnDiv = findViewById(R.id.btnDivision);
        btnAdd = findViewById(R.id.btnAddition);
        btnMul = findViewById(R.id.btnMultiplication);
        btnSub = findViewById(R.id.btnSubtraction);

        // Sự kiện khi nhấn nút "Trừ"
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int first = Integer.parseInt(firstNumber.getText().toString());
                    int second = Integer.parseInt(secondNumber.getText().toString());
                    textView.setText(String.valueOf(first - second));
                } catch (NumberFormatException e) {
                    // Xử lý lỗi khi người dùng nhập không đúng định dạng số
                    textView.setText("Invalid Input");
                }
            }
        });

        // Sự kiện khi nhấn nút "Cộng"
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int first = Integer.parseInt(firstNumber.getText().toString());
                    int second = Integer.parseInt(secondNumber.getText().toString());
                    textView.setText(String.valueOf(first + second));
                } catch (NumberFormatException e) {
                    // Xử lý lỗi khi người dùng nhập không đúng định dạng số
                    textView.setText("Invalid Input");
                }
            }
        });

        // Sự kiện khi nhấn nút "Nhân"
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int first = Integer.parseInt(firstNumber.getText().toString());
                    int second = Integer.parseInt(secondNumber.getText().toString());
                    textView.setText(String.valueOf(first * second));
                } catch (NumberFormatException e) {
                    // Xử lý lỗi khi người dùng nhập không đúng định dạng số
                    textView.setText("Invalid Input");
                }
            }
        });

        // Sự kiện khi nhấn nút "Chia"
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int first = Integer.parseInt(firstNumber.getText().toString());
                    int second = Integer.parseInt(secondNumber.getText().toString());
                    if (second == 0) {
                        textView.setText("Cannot divide by zero");
                    } else {
                        textView.setText(String.valueOf((double) first / second));
                    }
                } catch (NumberFormatException e) {
                    // Xử lý lỗi khi người dùng nhập không đúng định dạng số
                    textView.setText("Invalid Input");
                }
            }
        });

        // Sự kiện khi nhấn nút "Quay lại"
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_ex2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
