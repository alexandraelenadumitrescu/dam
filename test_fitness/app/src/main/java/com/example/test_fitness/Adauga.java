package com.example.test_fitness;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Adauga extends AppCompatActivity {
    TextInputEditText tietPret;
    TextInputEditText tietNrSali;
    TextInputEditText tietNrAparate;
    TextInputEditText tietNrAntrenori;
    CheckBox cb;
    Intent intent;
    public final static String k="k";
    Button button;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga);
        initializare();
        intent=getIntent();
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(v->{
            if(valid()){
                Intent inte=new Intent(this, Lista2.class);
                inte.putExtra(k,buildFromView());
                setResult(RESULT_OK,inte);
                startActivity(inte);
            }
        });
        button.setOnClickListener(v->{
            if(valid()){
                intent.putExtra(k,buildFromView());
                setResult(RESULT_OK,intent);
                finish();
            }
            //Log.d("haide",buildFromView().toString());
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private ClubFitness buildFromView() {
        int nsali=Integer.parseInt(tietNrSali.getText().toString().trim());
        float pret=Float.parseFloat(tietPret.getText().toString().trim());
        int n2=Integer.parseInt(tietNrAparate.getText().toString().trim());
        int n3=Integer.parseInt(tietNrAntrenori.getText().toString().trim());
        boolean c=cb.isChecked();
        return new ClubFitness(pret,nsali,n2,n3,c);
    }

    private boolean valid() {
        if(tietNrSali==null){
            Toast.makeText(this, "nu ati introdus un numar de sali valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(tietNrAntrenori==null){
            Toast.makeText(this, "nu ati introdus un numar de antrenori valid", Toast.LENGTH_SHORT).show();
            return false;
        }if(tietNrAparate==null){
            Toast.makeText(this, "nu ati introdus un numar de aparatew valid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(tietPret==null){
            Toast.makeText(this, "nu ati introdus un pret valid", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void initializare() {
        tietPret=findViewById(R.id.tiet_pret);
        tietNrSali=findViewById(R.id.tiet_nrSali);
        tietNrAparate=findViewById(R.id.tiet_nrAparate);
        tietNrAntrenori=findViewById(R.id.tiet_nrAntrenori);
        cb=findViewById(R.id.cb);

    }
}