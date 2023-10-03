package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_ex3_signup extends AppCompatActivity implements View.OnClickListener  {
    Button back;
    private final String REQUIRE = "Require";

    EditText editTextUsername;
    EditText editTextPassword;
    EditText editTextConfirmPassword;
    Button buttonSignUp;
    TextView textViewSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_signup);
        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        textViewSignIn = findViewById(R.id.textViewSignIn);


        buttonSignUp.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);
    }



    private boolean checkInput() {
        if (TextUtils.isEmpty(editTextUsername.getText().toString())) {
            editTextUsername.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
            editTextPassword.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(editTextConfirmPassword.getText().toString())) {
            editTextConfirmPassword.setError(REQUIRE);
            return false;
        }

        if (!TextUtils.equals(editTextPassword.getText().toString(), editTextConfirmPassword.getText().toString())) {
            Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

     public void signUp() {
        if (!checkInput()) {
            return;
        }
        Toast.makeText(this, "Sign up success", Toast.LENGTH_SHORT).show();
    }

     public void singInForm() {
        Intent intent = new Intent(this, activity_ex3_signin.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSignUp) {
            signUp();
        } else if (v.getId() == R.id.textViewSignIn) {
            singInForm();
        }
    }
}