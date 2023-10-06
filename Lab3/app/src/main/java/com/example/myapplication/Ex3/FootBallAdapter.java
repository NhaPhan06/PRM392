package com.example.myapplication.Ex3;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class FootBallAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<FootBall> List;

    public FootBallAdapter(Context context, int layout, List<FootBall> list) {
        this.context = context;
        this.layout = layout;
        List = list;
    }

    @Override
    public int getCount() {
        return List.size();
    }

    @Override
    public Object getItem(int i) {
        return List.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView tvFullName = view.findViewById(R.id.tvFullName);
        TextView tvDOB = view.findViewById(R.id.tvDOB);
        ImageView countryFlag = view.findViewById(R.id.countryFlag);
        ImageView imageResource = view.findViewById(R.id.imageResource);

        FootBall footballList = List.get(position);
        tvFullName.setText(footballList.getFullName());
        tvDOB.setText(footballList.getDateOfBirth().toString());
        countryFlag.setImageResource(footballList.getCountryFlag());
        imageResource.setImageResource(footballList.getImageResource());
        return view;
    }
}
