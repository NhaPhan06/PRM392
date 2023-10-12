package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Ex1;
    Button Ex2;
    Button singin;
    Button insta;
    Button face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ex1 = (Button) findViewById(R.id.Ex1);
        Ex2 = (Button) findViewById(R.id.Ex2);
        singin = (Button) findViewById(R.id.singin);
        insta = (Button) findViewById(R.id.instagram);
        face = (Button) findViewById(R.id.facebook);

            Ex1.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, com.example.lab1.Ex1.class);
                startActivity(intent);
            });
        singin.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, com.example.lab1.activity_singin.class);
            startActivity(intent);
        });
        face.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, com.example.lab1.activity_facebook.class);
            startActivity(intent);
        });
        insta.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, com.example.lab1.activity_instagram.class);
            startActivity(intent);
        });
        Ex2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, com.example.lab1.Ex2.class);
            startActivity(intent);
        });
    }


}