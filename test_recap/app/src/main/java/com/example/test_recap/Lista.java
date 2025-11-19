package com.example.test_recap;

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

public class Lista extends AppCompatActivity {
    ArrayAdapter<ClubSportiv> adapter;
    ListView lv;
    ArrayList<ClubSportiv> cluburi=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        Intent inte=getIntent();
        lv=findViewById(R.id.lv);
        cluburi=inte.getSerializableExtra("k",ArrayList.class);
        lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cluburi));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}