package com.example.team_lab;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DepositActivity extends AppCompatActivity {

    private static final List<String> members = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        Button btnDeposit = findViewById(R.id.btnDeposit);
        EditText edtDepositAmount = findViewById(R.id.edtDepositAmount);

        btnDeposit.setOnClickListener(v -> {
            String amountStr = edtDepositAmount.getText().toString();
            if (amountStr.trim().isEmpty()) {
                edtDepositAmount.setError("Please enter deposit amount");
                edtDepositAmount.requestFocus();
                return;
            }
            try {
                int amount = Integer.parseInt(amountStr);
                if (amount <= 0) {
                    edtDepositAmount.setError("Please enter a valid amount");
                    edtDepositAmount.requestFocus();
                    return;
                }
                Toast.makeText(this, "Successfully deposited $" + amountStr + "!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DepositActivity.this, MainActivity.class);
                intent.putExtra("depositAmount", amount);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                Toast.makeText(DepositActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}