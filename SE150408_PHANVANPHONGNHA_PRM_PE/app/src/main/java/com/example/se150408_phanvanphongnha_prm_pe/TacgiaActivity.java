package com.example.se150408_phanvanphongnha_prm_pe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TacgiaActivity extends AppCompatActivity {
    TacgiaAdapter adapter;
    ArrayList<Tacgia> arr;
    ListView listView;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tacgia);

        arr = new ArrayList<>();
        listView = findViewById(R.id.lvTacgia);

        adapter = new TacgiaAdapter(TacgiaActivity.this, R.layout.lv_tacgia, arr);
        listView.setAdapter(adapter);

        database = new Database(TacgiaActivity.this, "pe.sqlite", null, 1);

        database.QueryData("Create table if not exists TacGia" +
                "(id Integer primary key Autoincrement, TenTacGia nvarchar(100), DiaChi nvarchar(100), DienThoai nvarchar(100))");
        database.QueryData("Create table if not exists Sach" +
                "(masach Integer primary key Autoincrement, TenSach nvarchar(100), NgayXuatBan nvarchar(100), TheLoai nvarchar(100), IdTacGia Integer)");

/*        database.QueryData("Insert into Sach values(null,'Toi Thay Hoa Vang Tren Co Xanh','1/1/2005', 'Thieu Nhi','1')");
        database.QueryData("Insert into TacGia values(null,'Nguyen Nhat Anh', 'Ha Noi', '0997381211')");*/

        Get();

    }

    private void Get() {
        Cursor data = database.GetData("Select * from TacGia");
        arr.clear();
        while (data.moveToNext()) {
            int id = data.getInt(0);
            String ten = data.getString(1);
            String diachi = data.getString(2);
            String dt = data.getString(3);
            arr.add(new Tacgia(id, ten, diachi, dt));
        }
        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        int id = item.getItemId();
        if (id == R.id.menuAdd){
            Add();
        }
        if (id == R.id.menuN) {
            i = new Intent(this, SachActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.menuSv) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void Add() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_tg);
        dialog.setCanceledOnTouchOutside(false);

        EditText name = dialog.findViewById(R.id.edtCreateName);
        EditText add = dialog.findViewById(R.id.edtDiachi);
        EditText phone = dialog.findViewById(R.id.edtDienThoai);

        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = name.getText().toString();
                String diachi = add.getText().toString();
                String dt = phone.getText().toString();

                if (ten.equals("") || diachi.equals("") || dt.equals("")) {
                    Toast.makeText(TacgiaActivity.this, "Vui long nhap du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    database.QueryData("Insert into TacGia values(null,'" + ten + "','" + diachi + "','" + dt + "')");
                    Toast.makeText(TacgiaActivity.this, "Da them", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    Get();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void Delete(String ten, int id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Ban co muon xoa " + ten + "khong?");

        dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                database.QueryData("Delete from TacGia where id='" + id + "'");
                Toast.makeText(TacgiaActivity.this, "Đã Xóa " + ten, Toast.LENGTH_LONG).show();
                Get();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

    public void Update(int id, String ten, String dob, String gt) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update_tg);
        dialog.setCanceledOnTouchOutside(false);

        EditText edtDiachi = dialog.findViewById(R.id.edtDiachi);
        EditText edtDienThoai = dialog.findViewById(R.id.edtDienThoai);

        edtDiachi.setText(dob);
        edtDienThoai.setText(gt);

        Button btnConfirm = dialog.findViewById(R.id.btnConfirm);
        Button btnCancel = dialog.findViewById(R.id.btnCancel2);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diachi2 = edtDiachi.getText().toString();
                String dt2 = edtDienThoai.getText().toString();
                //id Integer primary key Autoincrement, TenNV nvarchar(100), NgaySinh nvarchar(100), GioiTinh nvarcahr(100))
                database.QueryData("Update TacGia set DiaChi='" + diachi2 + "',DienThoai='" + dt2 + "' where id= '" + id + "' ");
                Toast.makeText(TacgiaActivity.this, "Da Sua", Toast.LENGTH_LONG).show();
                dialog.dismiss();
                Get();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}