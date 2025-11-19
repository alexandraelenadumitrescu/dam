package com.example.salafitness;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Proba_practica_1 extends AppCompatActivity {
    Button btn;
    Button btnLista;
    Intent intent;
    ActivityResultLauncher<Intent> launcher;
    ArrayList<ClubFitness> cluburi=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button_adauga);
        btnLista=findViewById(R.id.button_lista);

        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{
            if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                ClubFitness c;

                c=(ClubFitness) result.getData().getSerializableExtra(Adauga_inregistrare.key);
                cluburi.add(c);
            }



        });
        btnLista.setOnClickListener(v->{
            intent=new Intent(this, Lista_inregistrari.class);
            intent.putExtra(Adauga_inregistrare.key,cluburi);
            //launcher.launch(intent);
            startActivity(intent);
        });
        btn.setOnClickListener(v->{
            intent=new Intent(this, Adauga_inregistrare.class);

            launcher.launch(intent);

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

//    private ActivityResultCallback<ActivityResult> callback() {
//        result->{
//            //
//        }
//    };
}