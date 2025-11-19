package com.example.test_fitness;

import android.app.AlertDialog;
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
    ListView lv;
    Intent intent;
    ArrayList<ClubFitness> cluburi;
    ArrayAdapter<ClubFitness> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        lv=findViewById(R.id.lv);
        intent=getIntent();
        cluburi=intent.getSerializableExtra(Adauga.k,ArrayList.class);
        adapter=new ArrayAdapter<ClubFitness>(getApplicationContext(), android.R.layout.simple_list_item_1,cluburi);
        lv.setAdapter(adapter);
//        lv.setOnItemLongClickListener(((a,b,c,d)->{
//            intent=new Intent(getApplicationContext(), MainActivity.class);
//            int x= lv.getSelectedItemPosition();
//            intent.putExtra("doi",x);
//            setResult(RESULT_CANCELED,intent);
//            cluburi.remove(x);
//            adapter.notifyDataSetChanged();
//            return true;
//        }));
        lv.setOnItemLongClickListener((a,b,c,d)->{
            new AlertDialog.Builder(this).setMessage("stergi?").setNegativeButton("nu",null).setPositiveButton("da",(e,f)->{cluburi.remove(c);adapter.notifyDataSetChanged();}).show();
            cluburi.remove(c);
            return true;

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}