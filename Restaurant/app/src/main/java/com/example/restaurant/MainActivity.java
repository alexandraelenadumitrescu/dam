package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdauga;
    Button btnVizualizeaza;
    Intent intent;
    ActivityResultLauncher<Intent> launcher;
    ArrayList<Restaurant> restaurante=new ArrayList<>();
    Toolbar tb;
    public final static  String key="kk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{
            if(result.getData()!=null&&result.getResultCode()==RESULT_OK){
                Restaurant r=result.getData().getSerializableExtra(Adauga.k,Restaurant.class);
                restaurante.add(r);
                Log.d("s a adaugat",r.toString());
            }
        });
        btnAdauga=findViewById(R.id.button_adauga);
        btnVizualizeaza=findViewById(R.id.button_lista);
        tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        btnAdauga.setOnClickListener(v->{
            intent=new Intent(getApplicationContext(), Adauga.class);
            launcher.launch(intent);
        });
        btnVizualizeaza.setOnClickListener(v->{
            intent=new Intent(getApplicationContext(), Lista.class);
            intent.putExtra(key,restaurante);
            startActivity(intent);

        });

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
        if(item.getItemId()==R.id.it1){
            intent=new Intent(this, Adauga.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}