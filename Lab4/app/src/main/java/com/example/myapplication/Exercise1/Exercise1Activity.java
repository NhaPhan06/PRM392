package com.example.myapplication.Exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class Exercise1Activity extends AppCompatActivity {

    Button btnString;
    Button btnArray;
    Button btnNumber;
    Button btnObject;
    Button btnBundle;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        btnString = (Button) findViewById(R.id.btnString);
        btnArray = (Button) findViewById(R.id.btnArray);
        btnNumber = (Button) findViewById(R.id.btnNumber);
        btnObject = (Button) findViewById(R.id.btnObject);
        btnBundle = (Button) findViewById(R.id.btnBundle);

        Intent intent = new Intent(Exercise1Activity.this, Exercise1ShowActivity.class);

        btnString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("StringKey", "PRM");
                startActivity(intent);
            }
        });
        btnArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] stringArray = new String[]{"Item 1", "Item 2", "Item 3"};
                intent.putExtra("ArrayKey", stringArray);
                startActivity(intent);
            }
        });
        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("IntKey", 11);
                startActivity(intent);
            }
        });
        btnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student(1, "Ngo Nam", 1);
                intent.putExtra("Objectkey", student);
                startActivity(intent);


                startActivity(intent);
            }
        });
        btnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                // Truyền dữ liệu String
                bundle.putString("StringKey", "John");

                // Truyền dữ liệu số nguyên
                bundle.putInt("IntKey", 30);

                // Truyền đối tượng Serializable
                Student student = new Student(1, "Ngo Nam", 1);
                bundle.putSerializable("ObjectKey", student);

                // Truyền danh sách chuỗi
                ArrayList<String> stringList = new ArrayList<>();
                stringList.add("Item 1");
                stringList.add("Item 2");
                bundle.putStringArrayList("ArrayKey", stringList);

                // Đặt Bundle vào Intent
                intent.putExtras(bundle);

                // Khởi động hoạt động mới với Intent
                startActivity(intent);
            }
        });

        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(view -> {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        });


    }
}