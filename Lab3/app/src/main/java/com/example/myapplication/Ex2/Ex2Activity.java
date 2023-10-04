package com.example.myapplication.Ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Ex1Activity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Ex2Activity extends AppCompatActivity {
    ListView list;
    List<TraiCay> traiCayList;
    TraiCayAdapter traiCayAdapter;
    Button back;
    private int selectedPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        AnhXa();
        traiCayAdapter = new TraiCayAdapter(this, R.layout.traicay_list, traiCayList);
        list.setAdapter(traiCayAdapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                traiCayList.remove(position);
                traiCayAdapter.notifyDataSetChanged();
                return true;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                selectedPosition = position;
                TraiCay selectedTraiCay = traiCayList.get(position);

                // Truyền dữ liệu lên EditText
                EditText editTextTen = findViewById(R.id.editText1); // Thay thế bằng id thích hợp
                EditText editTextMota = findViewById(R.id.editText2); // Thay thế bằng id thích hợp

                editTextTen.setText(selectedTraiCay.getTen());
                editTextMota.setText(selectedTraiCay.getMota());
            }
        });

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