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
    Button btnCreate;
    Button btnUpdate;
    EditText txtTen;
    EditText txtMoTa;
    private int selectedPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        AnhXa();
        traiCayAdapter = new TraiCayAdapter(this, R.layout.traicay_list, traiCayList);
        list.setAdapter(traiCayAdapter);

        back = (Button) findViewById(R.id.back);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        txtTen = (EditText) findViewById(R.id.editText1);
        txtMoTa = (EditText) findViewById(R.id.editText2);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                traiCayList.remove(position);
                traiCayAdapter.notifyDataSetChanged();
                return true;
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedPosition != -1) {
                    TraiCay updatedTraiCay = traiCayList.get(selectedPosition);
                    updatedTraiCay.setTen(txtTen.getText().toString());
                    updatedTraiCay.setMota(txtMoTa.getText().toString());
                    traiCayAdapter.notifyDataSetChanged();
                    selectedPosition = -1;
                    txtTen.setText("");
                    txtMoTa.setText("");
                }
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtTen.getText().toString();
                String moTa = txtMoTa.getText().toString();

                if (!ten.isEmpty() && !moTa.isEmpty()) {
                    TraiCay newTraiCay = new TraiCay(ten, moTa, R.drawable.tao2);
                    traiCayList.add(newTraiCay);
                    traiCayAdapter.notifyDataSetChanged();
                    txtTen.setText("");
                    txtMoTa.setText("");
                } else {
                    Toast.makeText(Ex2Activity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
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