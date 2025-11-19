package com.example.test_fitness;

import static com.example.test_fitness.Adauga.k;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdauga;
    Button btnViz;
    Intent intent;
    TextView tv;
    ActivityResultLauncher<Intent> launcher;
    ArrayList<ClubFitness> cluburi=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnAdauga=findViewById(R.id.btn_adauga);
        btnViz=findViewById(R.id.btn_vizualizeaza);
        tv=findViewById(R.id.textView);
        tv.setText(LocalDateTime.now().toString());
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{
            if(result.getData()!=null&&result.getResultCode()==RESULT_OK){
                //ClubFitness cb=result.getSerializableExtra(k, ClubFitness.class);
                Log.d("princiapa","m am intors in prnicipaal");
                ClubFitness cb=result.getData().getSerializableExtra(k,ClubFitness.class);
                Log.d("principala","am primit obiectul"+cb.toString());

                cluburi.add(cb);
                Log.d("prnicpalla",cluburi.toString());
            }

        });
        btnViz.setOnClickListener(v->{
            intent=new Intent(getApplicationContext(), Lista.class);
            intent.putExtra(k,cluburi);
            startActivity(intent);
        });
        btnAdauga.setOnClickListener(v->{
            intent=new Intent(getApplicationContext(), Adauga.class);
            launcher.launch(intent);
        });
//        intent=getIntent();
//        int x=intent.getSerializableExtra("doi",int.class);
//        cluburi.remove(x);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}