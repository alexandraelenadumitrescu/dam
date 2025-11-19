package com.example.salafitness;



import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class Lista_inregistrari extends AppCompatActivity {
    ListView lv;
    ArrayList<ClubFitness> cluburi;
    Intent intent;
    ArrayAdapter<ClubFitness> adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_inregistrari);
        lv=findViewById(R.id.listview);
        intent=getIntent();
        cluburi=(ArrayList<ClubFitness>) intent.getSerializableExtra(Adauga_inregistrare.key);
         adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,cluburi);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((parent,view,position,id)->{
            crdialog(position);
        });
        adapter.notifyDataSetChanged();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void crdialog(int position){
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setMessage("stergem sala");
        b.setPositiveButton("da", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cluburi.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        b.setNegativeButton("nu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        b.create().show();
    }
}