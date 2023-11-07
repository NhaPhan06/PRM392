package com.example.feedbackmanagementsystem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.feedbackmanagementsystem.R;
import com.example.feedbackmanagementsystem.models.Trainee;

import java.util.ArrayList;

public class ListTraineeAdapter extends BaseAdapter {

    private ArrayList<Trainee> listTrainee;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListTraineeAdapter(ArrayList<Trainee> listTrainee) {
        this.listTrainee = listTrainee;
    }

    @Override
    public int getCount() {
        return listTrainee.size();
    }

    @Override
    public Object getItem(int position) {
        return listTrainee.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewTrainee;
        if(convertView == null){
            viewTrainee = View.inflate(parent.getContext(), R.layout.item_trainee ,null);
        }
        else{
            viewTrainee = convertView;
        }
        Trainee trainee = (Trainee) getItem(position);
        ((TextView) viewTrainee.findViewById(R.id.txtName)).setText(String.format("" + trainee.getName()));
        ((TextView) viewTrainee.findViewById(R.id.txtEmail)).setText(String.format("" + trainee.getEmail()));
        ((TextView) viewTrainee.findViewById(R.id.txtGender)).setText(String.format("" + trainee.getGender()));
        ((TextView) viewTrainee.findViewById(R.id.txtPhone)).setText(String.format("" + trainee.getPhone()));

        return viewTrainee;
    }
}
