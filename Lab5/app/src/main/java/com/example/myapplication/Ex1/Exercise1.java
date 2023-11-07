package com.example.myapplication.Ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Ex1.Adapter.UserAdapter;
import com.example.myapplication.Ex1.Model.User;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 extends AppCompatActivity {

    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        RecyclerView rvUserList = findViewById(R.id.rvUserList);

        users = new ArrayList<>();
        users.add(new User("duynd", "Nguyen Dinh Duy", "duyndse@gmail.com"));
        users.add(new User("nghiatt", "Ton Trong Nghia", "nghiatt@gmail.com"));
        users.add(new User("nguyenndk", "Ngo Dinh Khoi Nguyen", "nguyenndk@gmail.com"));
        users.add(new User("trungnt", "Nguyen Thanh Trung", "trungnt@gmail.com"));
        users.add(new User("hungtm", "Tran Manh Hung", "hungtm@gmail.com"));

        UserAdapter userAdapter = new UserAdapter(users);
        rvUserList.setAdapter(userAdapter);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
    }
}