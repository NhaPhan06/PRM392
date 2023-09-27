package com.example.myapplication;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<TraiCay> TraiCayList;

    public TraiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        TraiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return TraiCayList.size();
    }

    @Override
    public Object getItem(int i) {
        return TraiCayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView tvTraiCay = view.findViewById(R.id.tvTraiCay);
        TextView tvMoTa = view.findViewById(R.id.tvMoTa);
        ImageView imageResource = view.findViewById(R.id.imageResource);

        TraiCay traicay = TraiCayList.get(i);

        return view;
    }
}
