package com.example.customadapteri.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.customadapteri.R;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private int resource;
    private List<Student> students=new ArrayList<>();
    LayoutInflater inflater;
    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects,LayoutInflater inflater) {

        super(context, resource, objects);
        this.context=context;
        this.resource= R.layout.lv_row;
        this.inflater=inflater;
        this.students=objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=inflater.inflate(resource,parent,false);
        Student s=students.get(position);
        TextView tvDate=view.findViewById(R.id.tow_tv_date);
        tvDate.setText(s.getDataNastere().toString());
        TextView tvNume=view.findViewById(R.id.tow_tv_nume);
        tvNume.setText(s.getNume());
        return view;

    }
}
