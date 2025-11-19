package com.example.test_recap;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import kotlin.internal.ContractsDsl;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Toolbar tb;
    Button btnAdauga;
    Button btnViz;

    Intent intent;
    ActivityResultLauncher<Intent> launcher;
    ArrayList<ClubSportiv> cluburi=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        LocalDateTime d= LocalDateTime.now();
        tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        btnAdauga=findViewById(R.id.button);
        btnViz=findViewById(R.id.button2);
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{
            if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                ClubSportiv club=result.getData().getSerializableExtra(Adauga.key, ClubSportiv.class);
                cluburi.add(club);
            }
        });
        btnAdauga.setOnClickListener(v->{
            intent=new Intent(getApplicationContext(), Adauga.class);
            launcher.launch(intent);

        });
        btnViz.setOnClickListener(v->{
            Intent inte=new Intent(this, Lista.class);
            inte.putExtra("k",cluburi);
            startActivity(inte);
        });
        tv.setText(java.time.LocalDateTime.now().toString());
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
            Toast.makeText(this,"ai apasat un buton din meniu",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}