package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    List<TraiCay> traiCayList;
    TraiCayAdapter traiCayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traicay_main);
        AnhXa();
        traiCayAdapter = new TraiCayAdapter(this, R.layout.traicay_list, traiCayList);
        list.setAdapter(traiCayAdapter);
    }

    private void AnhXa() {
        list = findViewById(R.id.list_item);
        traiCayList = new ArrayList<>();
        traiCayList.add(new TraiCay("Tao","Tao co nhieu chat dinh duong", R.drawable.tao2));
        traiCayList.add(new TraiCay("Dua","Dua co nhieu chat dinh duong", R.drawable.dua));
    }
}