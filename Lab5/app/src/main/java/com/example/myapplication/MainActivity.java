package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.Ex1.Exercise1;
import com.example.myapplication.Ex2.Exercise2;

public class MainActivity extends AppCompatActivity {

    Button Ex1;
    Button Ex2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ex1 = (Button) findViewById(R.id.Ex1);
        Ex2 = (Button) findViewById(R.id.Ex2);

        Ex1.setOnClickListener(view -> {
            Intent intent = new Intent(this, Exercise1.class);
            startActivity(intent);
        });
        Ex2.setOnClickListener(view -> {
            Intent intent = new Intent(this, Exercise2.class);
            startActivity(intent);
        });
    }
}