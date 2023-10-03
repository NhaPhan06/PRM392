package com.example.myapplication.Ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Ex2Activity extends AppCompatActivity {
    ListView list;
    List<TraiCay> traiCayList;
    TraiCayAdapter traiCayAdapter;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        AnhXa();
        traiCayAdapter = new TraiCayAdapter(this, R.layout.traicay_list, traiCayList);
        list.setAdapter(traiCayAdapter);

        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void AnhXa() {
        list = findViewById(R.id.list_item);
        traiCayList = new ArrayList<>();
        traiCayList.add(new TraiCay("Tao","Tao co nhieu chat dinh duong", R.drawable.tao2));
        traiCayList.add(new TraiCay("Dua","Dua co nhieu chat dinh duong", R.drawable.dua));
    }
}