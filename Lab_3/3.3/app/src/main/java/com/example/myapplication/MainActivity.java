package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    List<FootBall> footBallListlist;
    FootBallAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        AnhXa();
        Adapter = new FootBallAdapter(this, R.layout.list, footBallListlist);
        list.setAdapter(Adapter);
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