package com.example.se150408_phanvanphongnha_prm_pe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TacgiaAdapter extends BaseAdapter {
    private TacgiaActivity context;
    private int layout;
    private ArrayList<Tacgia> arr;

    public TacgiaAdapter(TacgiaActivity context, int layout, ArrayList<Tacgia> arr) {
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
        TextView txtId, txtTen, txtDiaChi, txtDienThoai;
        ImageView imgEdit, imgTrash;

        public ViewHolder() {
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TacgiaAdapter.ViewHolder viewHolder = null;

        if (viewHolder == null) {
            viewHolder = new TacgiaAdapter.ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.lv_tacgia, null);


            viewHolder.txtId = (TextView) convertView.findViewById(R.id.lv_Tacgia);
            viewHolder.txtTen = (TextView) convertView.findViewById(R.id.lv_Ten);
            viewHolder.txtDiaChi = (TextView) convertView.findViewById(R.id.lv_DiaChi);
            viewHolder.txtDienThoai = (TextView) convertView.findViewById(R.id.lv_DienThoai);

            viewHolder.imgEdit = (ImageView) convertView.findViewById(R.id.iconEdit);
            viewHolder.imgTrash = (ImageView) convertView.findViewById(R.id.iconDelete);

            convertView.setTag(viewHolder);
        }

        Tacgia tacgia = arr.get(position);
        viewHolder.txtId.setText(Integer.toString(tacgia.getId()));
        viewHolder.txtTen.setText(tacgia.getTenTacGia());
        viewHolder.txtDiaChi.setText(tacgia.getDiaChi());
        viewHolder.txtDienThoai.setText(tacgia.getDienThoai());


        viewHolder.imgTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.Delete(tacgia.getTenTacGia(),tacgia.getId());
            }
        });


        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.Update(tacgia.getId(),tacgia.getTenTacGia(), tacgia.getDiaChi(), tacgia.getDienThoai());
            }
        });

        return convertView;
    }
}
