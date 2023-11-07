package com.example.se150408_phanvanphongnha_prm_pe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SachAdapter extends BaseAdapter {
    private SachActivity context;
    private int layout;
    private ArrayList<Sach> arr;

    public SachAdapter(SachActivity context, int layout, ArrayList<Sach> arr) {
        this.context = context;
        this.layout = layout;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtId, txtTen, txtNgayXB, txtTheLoai, txtIdTacGia;
        ImageView imgEdit, imgTrash;

        public ViewHolder() {
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SachAdapter.ViewHolder viewHolder = null;

        if (viewHolder == null) {
            viewHolder = new SachAdapter.ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.lv_sach, null);


            viewHolder.txtId = (TextView) convertView.findViewById(R.id.lv_Sach);
            viewHolder.txtTen = (TextView) convertView.findViewById(R.id.lv_TenSach);
            viewHolder.txtNgayXB = (TextView) convertView.findViewById(R.id.lv_NgayXB);
            viewHolder.txtTheLoai = (TextView) convertView.findViewById(R.id.lv_TheLoai);
            viewHolder.txtIdTacGia = (TextView) convertView.findViewById(R.id.lv_IdTacGia);


            viewHolder.imgEdit = (ImageView) convertView.findViewById(R.id.iconEdit);
            viewHolder.imgTrash = (ImageView) convertView.findViewById(R.id.iconDelete);

            convertView.setTag(viewHolder);
        }

        Sach sach = arr.get(position);
        viewHolder.txtId.setText(Integer.toString(sach.getMaSach()));
        viewHolder.txtTen.setText(sach.getTenSach());
        viewHolder.txtNgayXB.setText(sach.getNgayXB());
        viewHolder.txtTheLoai.setText(sach.getTheLoai());
        viewHolder.txtIdTacGia.setText(Integer.toString(sach.getIdTacGia()));


        viewHolder.imgTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.Delete(sach.getTenSach(),sach.getMaSach());
            }
        });


        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.Update(sach.getMaSach(),sach.getTenSach(), sach.getNgayXB(), sach.getTheLoai());
            }
        });

        return convertView;
    }


}
