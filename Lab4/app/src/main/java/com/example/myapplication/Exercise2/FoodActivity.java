package com.example.myapplication.Exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    private static int CURRENT_POST = -1;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ListView listFood = findViewById(R.id.idListFood);
        EditText editFood = findViewById(R.id.editFood);
        Button btnOrder = findViewById(R.id.idbtnOrder);

        btnBack = findViewById(R.id.idbtnExit);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodActivity.this,Exercise2Activity.class);
                startActivity(intent);
            }
        });

        List<String> stringList = new ArrayList<>();
        stringList.add("Phở Hà Nội");
        stringList.add("Bún Bò Huế");
        stringList.add("Mì Quảng");
        stringList.add("Hủ Tíu Sài Gòn");
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.foodlist, R.id.idFoodText, stringList);
        listFood.setAdapter(adapter);

        listFood.setOnItemClickListener((parent, view, position, id) -> {
            editFood.setText(stringList.get(position));
            CURRENT_POST = position;
        });



        btnOrder.setOnClickListener(view -> {
            String chooseFood = editFood.getText().toString().trim();
            if (chooseFood.isEmpty()) {
                editFood.setError("Vui chọn món ăn!");
                editFood.requestFocus();
            }
            else{

                Intent intent = new Intent(this, Exercise2Activity.class);
                intent.putExtra("key", chooseFood);
                stringList.add(chooseFood);
                startActivity(intent);
            }
        });

    }
}