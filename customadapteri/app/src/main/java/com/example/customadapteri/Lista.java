package com.example.customadapteri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.customadapteri.domain.Student;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    Intent intent;
    ArrayList<Student> studenti=new ArrayList<>();
    ArrayAdapter<Student> adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        intent=getIntent();
        studenti=intent.getSerializableExtra("k", ArrayList.class);
        lv=findViewById(R.id.lv);
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,studenti);
        lv.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}