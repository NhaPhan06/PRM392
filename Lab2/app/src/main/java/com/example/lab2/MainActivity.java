package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Ex1;
    Button Ex2;
    Button Ex3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ex1 = (Button) findViewById(R.id.Ex1);
        Ex2 = (Button) findViewById(R.id.Ex2);
        Ex3 = (Button) findViewById(R.id.Ex3);

        Ex1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, activity_ex1.class);
            startActivity(intent);
        });
        Ex2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, activity_ex2.class);
            startActivity(intent);
        });
        Ex3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, activity_ex3_signin.class);
            startActivity(intent);
        });
    }

}