package com.example.myapplication.Exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Exercise1ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1_show);

        Intent intent = getIntent();


        String stringData = intent.getStringExtra("StringKey");
        int numberData = intent.getIntExtra("IntKey", 0);
        String[] arrayData = getIntent().getStringArrayExtra("ArrayKey");
        String arrayText = "";
        if (arrayData != null) {
            for (String item : arrayData) {
                arrayText += item + " ";
            }
        }
        Student objectData = (Student) intent.getSerializableExtra("ObjectKey");
        String student = "";
        if (objectData != null){
            student = objectData.getName() + "" + objectData.getGrade();
        }
        TextView textString = findViewById(R.id.textString);
        TextView textArray = findViewById(R.id.textArray);
        TextView textNumber = findViewById(R.id.textNumber);
        TextView textObject = findViewById(R.id.textObject);

        textString.setText("String Data: " + stringData);
        textArray.setText("Array Data: " + arrayText);
        textNumber.setText("Number Data: " + numberData);
        textObject.setText("Object Data: " + student);
    }
}