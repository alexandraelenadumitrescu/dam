package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Lista_inregistrari extends AppCompatActivity {
    Toolbar tb;
    ActivityResultLauncher<Intent> launcher;
    ActivityResultLauncher<Intent> launcher2;
    ArrayList<Facultate> facultati=new ArrayList<>();
    ArrayAdapter<Facultate> adapter;
    ListView lv;
    Intent intent;
    int pos;
    Facultate basic=new Facultate(123,"NUME","STRADA", Date.from(Instant.now()),true);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_inregistrari);
        tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        facultati.add(basic);

        lv=findViewById(R.id.lv);
        adapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,facultati);
        adapter.notifyDataSetChanged();
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((context,view,position,element)->{
            intent=new Intent(getApplicationContext(),Adauga_inregistrare.class);
            intent.putExtra(Adauga_inregistrare.key,facultati.get(position));
            pos=position;
            launcher2.launch(intent);
        });
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{
            if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                Facultate f=result.getData().getSerializableExtra(Adauga_inregistrare.key,Facultate.class);
                facultati.add(f);
                Log.d("adaugat",facultati.toString());



                adapter.notifyDataSetChanged();

            }
        });
        launcher2=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{
            if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                facultati.remove(pos);
                Facultate f=result.getData().getSerializableExtra(Adauga_inregistrare.key,Facultate.class);
                facultati.add(pos,f);
                Log.d("adaugat",facultati.toString());



                adapter.notifyDataSetChanged();

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_it_adauga){
            Intent intent=new Intent(this,Adauga_inregistrare.class);
            launcher.launch(intent);
        }
        if(item.getItemId()==R.id.menu_it2_exit){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}