package com.example.myapplication.Exercise1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    List<User> users;
    Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        RecyclerView rvUserList = findViewById(R.id.rvUserList);
        Back = (Button) findViewById(R.id.back);


        Back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        users = new ArrayList<>();
        users.add(new User("Duy", "Bao Duy", "duy@gmail.com"));
        users.add(new User("Hoang", "Dinh Hoang", "hoang@gmail.com"));
        UserAdapter userAdapter = new UserAdapter(users);
        rvUserList.setAdapter(userAdapter);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
    }
}