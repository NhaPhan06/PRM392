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

import java.sql.Date;
import java.util.ArrayList;

public class SachActivity extends AppCompatActivity {
    SachAdapter adapter;
    ArrayList<Sach> arr;
    ListView listView;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);

        arr = new ArrayList<>();
        listView = findViewById(R.id.lvSach);

        adapter = new SachAdapter(SachActivity.this, R.layout.lv_sach, arr);
        listView.setAdapter(adapter);

        database = new Database(SachActivity.this, "pe.sqlite", null, 1);
/*        database.QueryData("Create table if not exists TacGia" +
                "(id Integer primary key Autoincrement, TenTacGia nvarchar(100), DiaChi nvarchar(100), DienThoai nvarchar(100))");
        database.QueryData("Create table if not exists Sach" +
                "(masach Integer primary key Autoincrement, TenSach nvarchar(100), NgayXuatBan nvarchar(100), TheLoai nvarchar(100), IdTacGia Integer)");

        database.QueryData("Insert into Sach values(null,'Toi Thay Hoa Vang Tren Co Xanh','1/1/2005', 'Thieu Nhi','1')");
        database.QueryData("Insert into TacGia values(null,'Nguyen Nhat Anh', 'Ha Noi', '0997381211')");*/

        Get();

    }
    private void Get() {
        Cursor data = database.GetData("Select * from Sach");
        arr.clear();
        while (data.moveToNext()) {
            int id = data.getInt(0);
            String ten = data.getString(1);
            String NgayXB = data.getString(2);
            String theloai = data.getString(3);
            int taciga = data.getInt(4);
            arr.add(new Sach(id, ten, NgayXB, theloai, taciga));
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
            return true;
        }
        if (id == R.id.menuSv) {
            i = new Intent(this, TacgiaActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void Add() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_s);
        dialog.setCanceledOnTouchOutside(false);

        EditText name = dialog.findViewById(R.id.addSach);
        EditText xb = dialog.findViewById(R.id.addNgayXB);
        EditText theloai = dialog.findViewById(R.id.addTheLoai);
        EditText tacgia = dialog.findViewById(R.id.addTacGia);

        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = name.getText().toString();
                String nxb = xb.getText().toString();
                String tl = theloai.getText().toString();
                String id = tacgia.getText().toString();

                if (ten.equals("") || nxb.equals("") || tl.equals("")|| id.equals("")) {
                    Toast.makeText(SachActivity.this, "Vui long nhap du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    database.QueryData("Insert into Sach values(null,'" + ten + "','" + nxb + "','" + tl+ "','" + id + "')");
                    Toast.makeText(SachActivity.this, "Da them", Toast.LENGTH_LONG).show();
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
                database.QueryData("Delete from Sach where masach='" + id + "'");
                Toast.makeText(SachActivity.this, "Đã Xóa " + ten, Toast.LENGTH_LONG).show();
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

    public void Update(int id, String ten, String NgayXB, String theloai) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update_s);
        dialog.setCanceledOnTouchOutside(false);

        EditText edtTen = dialog.findViewById(R.id.upTenSach);
        EditText edtNgayXB = dialog.findViewById(R.id.upNgayXb);
        EditText edttl = dialog.findViewById(R.id.upTheLoai);

        edtTen.setText(ten);
        edtNgayXB.setText(NgayXB);
        edttl.setText(theloai);

        Button btnConfirm = dialog.findViewById(R.id.btnConfirmup);
        Button btnCancel = dialog.findViewById(R.id.btnCancelup);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtTen.getText().toString();
                String xb = edtNgayXB.getText().toString();
                String tl = edttl.getText().toString();
                //id Integer primary key Autoincrement, TenNV nvarchar(100), NgaySinh nvarchar(100), GioiTinh nvarcahr(100))
                database.QueryData("Update Sach set TenSach='" + ten + "',NgayXuatBan='" + xb + "', TheLoai= " + theloai +" where id= '" + id + "' ");
                Toast.makeText(SachActivity.this, "Da Sua", Toast.LENGTH_LONG).show();
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
