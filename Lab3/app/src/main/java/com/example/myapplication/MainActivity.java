package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.Ex2.Ex2Activity;
import com.example.myapplication.Ex3.Ex3Activity;

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
            Intent intent = new Intent(this, Ex1Activity.class);
            startActivity(intent);
        });
        Ex2.setOnClickListener(view -> {
            Intent intent = new Intent(this, Ex2Activity.class);
            startActivity(intent);
        });
        Ex3.setOnClickListener(view -> {
            Intent intent = new Intent(this, Ex3Activity.class);
            startActivity(intent);
        });
    }
}