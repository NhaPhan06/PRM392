package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.Exercise1.UserActivity;
import com.example.myapplication.Exercise1.UserAdapter;

public class MainActivity extends AppCompatActivity {

    Button Ex1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ex1 = (Button) findViewById(R.id.Ex1);

        Ex1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, com.example.myapplication.Exercise1.UserActivity.class);
            startActivity(intent);
        });

    }
}