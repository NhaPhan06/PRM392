package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tao database ghi chu
        database = new Database(this, "GhiChu.sqlite", null, 1);

        //tao table cong viec
        database.QueryData("Create table if not exists CongViec(id Interger Primary Key Autoincrement,"+"TenCV nvarchar(200))");

        //insert data
        database.QueryData("Insert into CongViec values(null, 'Project Android')");
        database.QueryData("Insert into CongViec values(null, 'Design app')");

        //Select data
        Cursor dataCongViec = database.GetData("Select * From CongViec");
        while (dataCongViec.moveToNext()){
            String ten= dataCongViec.getString( 1);
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
    }
}