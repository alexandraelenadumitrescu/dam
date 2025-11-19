package com.example.test_fitness;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Lista2 extends AppCompatActivity {
    ListView lv;
    ArrayList<ClubFitness> cluburi=new ArrayList<>();
    ArrayAdapter<ClubFitness> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista2);
        lv=findViewById(R.id.lv22);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cluburi);
        lv.setAdapter(adapter);
        Intent intent=getIntent();
        cluburi.add(intent.getSerializableExtra(Adauga.k,ClubFitness.class));
        adapter.notifyDataSetChanged();



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}