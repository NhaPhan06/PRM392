package com.example.myapplication.Ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Ex2.Adapter.PhoneAdapter;
import com.example.myapplication.Ex2.Model.Phone;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 extends AppCompatActivity {

    List<Phone> phones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        RecyclerView rvPhoneList = findViewById(R.id.rvPhoneList);

        phones = new ArrayList<>();
        phones.add(new Phone("iPhone SE", "Apple", 2020, 100, R.drawable.iphonese));
        phones.add(new Phone("iPhone 11", "Apple", 2020, 100, R.drawable.iphone11));
        phones.add(new Phone("iPhone 12", "Apple", 2020, 100, R.drawable.iphone12));
        phones.add(new Phone("iPhone 13", "Apple", 2020, 100, R.drawable.iphone13));
        phones.add(new Phone("iPhone 13 Pro", "Apple", 2020, 100, R.drawable.iphone13pro));

        rvPhoneList.setAdapter(new PhoneAdapter(phones));
        rvPhoneList.setLayoutManager(new LinearLayoutManager(this));

    }
}