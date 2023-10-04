package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnString;
    Button btnArray;
    Button btnNumber;
    Button btnObject;
    Button btnBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnString = (Button) findViewById(R.id.btnString);
        btnArray = (Button) findViewById(R.id.btnArray);
        btnNumber = (Button) findViewById(R.id.btnNumber);
        btnObject = (Button) findViewById(R.id.btnObject);
        btnBundle = (Button) findViewById(R.id.btnBundle);

        btnString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("key", "PRM");
                startActivity(intent);
            }
        });
        btnArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> stringList = new ArrayList<>();
                stringList.add("Item 1");
                stringList.add("Item 2");
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("key", stringList);
                startActivity(intent);
            }
        });
        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("key", 11);
                startActivity(intent);
            }
        });
        btnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student(1, "Ngo Nam", 1);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("key", student);
                startActivity(intent);
            }
        });
        btnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TRuyền dữ liệu cho Bundle
                Bundle bundle = new Bundle();
                ArrayList<String> stringList = new ArrayList<>();
                stringList.add("Item 1");
                stringList.add("Item 2");
                Student student = new Student(1, "Ngo Nam", 1);
                //put
                bundle.putString("string", "John");
                bundle.putInt("int", 30);
                bundle.putSerializable("object",student);
                bundle.putStringArrayList("key", stringList);
                //-------------------------
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }


}