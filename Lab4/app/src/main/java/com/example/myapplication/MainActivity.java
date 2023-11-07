package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Exercise1.Exercise1Activity;
import com.example.myapplication.Exercise1.Student;
import com.example.myapplication.Exercise2.Exercise2Activity;

import java.util.ArrayList;

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
            Intent intent = new Intent(this, Exercise1Activity.class);
            startActivity(intent);
        });
        Ex2.setOnClickListener(view -> {
            Intent intent = new Intent(this, Exercise2Activity.class);
            startActivity(intent);
        });
    }


}