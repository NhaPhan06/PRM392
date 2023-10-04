package com.example.myapplication.Ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Ex3Activity extends AppCompatActivity {
    Button back;
    ListView list;
    List<FootBall> footBallListlist;
    FootBallAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
        AnhXa();
        Adapter = new FootBallAdapter(this, R.layout.footbal_list, footBallListlist);
        list.setAdapter(Adapter);

        back = (Button) findViewById(R.id.back);

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