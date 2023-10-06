package com.example.myapplication.Ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Ex2.Ex2Activity;
import com.example.myapplication.Ex2.TraiCay;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ex3Activity extends AppCompatActivity {
    Button back;
    ListView list;
    List<FootBall> footBallListlist;
    FootBallAdapter Adapter;
    Button btnCreate;
    Button btnUpdate;
    EditText txtTen;
    EditText txtMoTa;
    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
        AnhXa();
        Adapter = new FootBallAdapter(this, R.layout.footbal_list, footBallListlist);
        list.setAdapter(Adapter);
        back = (Button) findViewById(R.id.back);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        txtTen = (EditText) findViewById(R.id.editText1);
        txtMoTa = (EditText) findViewById(R.id.editText2);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                footBallListlist.remove(position);
                Adapter.notifyDataSetChanged();
                return true;
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedPosition != -1) {
                    FootBall updated = footBallListlist.get(selectedPosition);
                    updated.setFullName(txtTen.getText().toString());

                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateInString = txtMoTa.getText().toString();
                    try {
                        Date date = formatter.parse(dateInString);
                        // Gán ngày tháng đã parse vào updated
                        updated.setDateOfBirth(date);
                        // Thông báo cho Adapter cập nhật lại giao diện
                        Adapter.notifyDataSetChanged();
                        selectedPosition = -1;
                        txtTen.setText("");
                        txtMoTa.setText("");
                    } catch (ParseException e) {
                        Toast.makeText(Ex3Activity.this, "Ngày tháng không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtTen.getText().toString();
                String moTa = txtMoTa.getText().toString();

                if (!ten.isEmpty() && !moTa.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateInString = txtMoTa.getText().toString();
                    Date date;
                    try {
                        date = formatter.parse(dateInString);
                        FootBall n = new FootBall(ten, date, R.drawable.ic_flag_argentina, R.drawable.messi);
                        footBallListlist.add(n);
                        Adapter.notifyDataSetChanged();
                        txtTen.setText("");
                        txtMoTa.setText("");
                    } catch (ParseException e) {
                        Toast.makeText(Ex3Activity.this, "Ngày tháng không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Ex3Activity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                selectedPosition = position;
                FootBall selected = footBallListlist.get(position);

                // Truyền dữ liệu lên EditText
                EditText editTextTen = findViewById(R.id.editText1); // Thay thế bằng id thích hợp
                EditText editTextMota = findViewById(R.id.editText2); // Thay thế bằng id thích hợp

                editTextTen.setText(selected.getFullName());
                editTextMota.setText(selected.getDateOfBirth().toString());
            }
        });


        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void AnhXa() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        list = findViewById(R.id.list_item);
        footBallListlist = new ArrayList<>();
        try {
            footBallListlist.add(new FootBall("Pele", dateFormat.parse("23-10-1940"), R.drawable.ic_flag_brazil, R.drawable.pele));
            footBallListlist.add(new FootBall("Lionel Messi", dateFormat.parse("24-06-1987"), R.drawable.ic_flag_argentina, R.drawable.messi));
            footBallListlist.add(new FootBall("Ronaldo De Lima", dateFormat.parse("22-09-1976"), R.drawable.ic_flag_brazil, R.drawable.ronaldo));
            footBallListlist.add(new FootBall("Diego Maradona", dateFormat.parse("30-10-1960"), R.drawable.ic_flag_argentina, R.drawable.maradona));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}