package com.example.myapplication.Exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Exercise2Activity extends AppCompatActivity {
    public static List<String> stringList = new ArrayList<>();
    Button btnFood;
    Button btnDrink;

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        ListView listView = findViewById(R.id.orderlist);


        Intent intent = getIntent();
        if (intent != null) {
            String giaTriNhanDuoc = intent.getStringExtra("key");

            // Sử dụng giá trị nhận được trong MainActivity
            if (giaTriNhanDuoc != null) {
                stringList.add(giaTriNhanDuoc);
            }
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.orderlist, R.id.idordertext, stringList);
        listView.setAdapter(adapter);

        btnFood = findViewById(R.id.idbtnfood);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Exercise2Activity.this, FoodActivity.class);
                intent1.putStringArrayListExtra("orderList", (ArrayList<String>) stringList);
                startActivity(intent1);
            }
        });

        btnDrink = findViewById(R.id.idbtndrink);
        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercise2Activity.this, DrinkActivity.class);
                intent.putStringArrayListExtra("orderList", (ArrayList<String>) stringList);
                startActivity(intent);
            }
        });

        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(view -> {
            Intent intent3 = new Intent(this, MainActivity.class);
            startActivity(intent3);
        });
    }
}