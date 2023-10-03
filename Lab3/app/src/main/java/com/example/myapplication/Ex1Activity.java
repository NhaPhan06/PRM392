package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Ex1Activity extends AppCompatActivity {

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        ListView listView = findViewById(R.id.listView);
        EditText editText = findViewById(R.id.editText);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnUpdate = findViewById(R.id.btnUpdate);

        List<String> list = new ArrayList<>();
        list.add("Android");
        list.add("PHP");
        list.add("IOS");
        list.add("Unity");
        list.add("C#");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Ex1Activity.this, list.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayAdapter.add(editText.getText().toString());
                listView.setAdapter(arrayAdapter);
            }
        });

        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}