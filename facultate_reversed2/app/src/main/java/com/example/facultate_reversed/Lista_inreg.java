package com.example.facultate_reversed;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Lista_inreg extends AppCompatActivity {
    Toolbar tb;
    Intent intent;
    ArrayList<Facultate> facultati=new ArrayList<>();
    ArrayAdapter<Facultate> adapter;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_inreg);
        tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        intent=getIntent();
        Facultate f;
        f=intent.getSerializableExtra(Adauga_inreg.key,Facultate.class);
        facultati.add(f);
        lv=findViewById(R.id.lv);
        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,facultati);
        adapter.notifyDataSetChanged();
        lv.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.item1){
            intent=new Intent(getApplicationContext(), Adauga_inreg.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}