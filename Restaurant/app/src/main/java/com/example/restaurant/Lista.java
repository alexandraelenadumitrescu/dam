package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    ArrayList<Restaurant> restaurante=new ArrayList<>();
    ListView lv;
    Intent intent;
    ActivityResultLauncher<Intent> launcher;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        lv=findViewById(R.id.lv);


        intent=getIntent();
        restaurante=intent.getSerializableExtra(MainActivity.key,ArrayList.class);
        ArrayAdapter<Restaurant> adapter=new ArrayAdapter<Restaurant>(this,android.R.layout.simple_list_item_1,restaurante);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}