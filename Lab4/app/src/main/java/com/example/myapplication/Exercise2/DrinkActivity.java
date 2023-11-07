package com.example.myapplication.Exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DrinkActivity extends AppCompatActivity {

    private static int CURRENT_POST = -1;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        ListView listDrink = findViewById(R.id.idListDrink);
        EditText editDrink = findViewById(R.id.editDrink);
        Button btnOrder = findViewById(R.id.idbtnOrder);

        btnBack = findViewById(R.id.idbtnExit);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DrinkActivity.this, Exercise2Activity.class);
                startActivity(intent);
            }
        });

        List<String> stringList = new ArrayList<>();
        stringList.add("Pepsi");
        stringList.add("Heineken");
        stringList.add("Tiger");
        stringList.add("Sài gòn Đỏ");
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, R.layout.drinklist, R.id.iddrinktext, stringList);
        listDrink.setAdapter(adapter);

        listDrink.setOnItemClickListener((parent, view, position, id) -> {
            editDrink.setText(stringList.get(position));
            CURRENT_POST = position;
        });

        btnOrder.setOnClickListener(view -> {
            String chooseFood = editDrink.getText().toString().trim();
            if (chooseFood.isEmpty()) {
                editDrink.setError("Vui chọn món ăn!");
                editDrink.requestFocus();
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