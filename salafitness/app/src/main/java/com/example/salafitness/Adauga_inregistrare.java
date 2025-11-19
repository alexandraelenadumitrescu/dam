package com.example.salafitness;

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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Adauga_inregistrare extends AppCompatActivity {
    TextInputEditText tietNume;
    TextInputEditText tietAdresa;
    TextInputEditText tietPret;
    TextInputEditText tietData;
    CheckBox cbEsteNonStop;
    Button btnSave;

    Intent intent;
    public final static String key="k";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_inregistrare);
        init();
        btnSave=findViewById(R.id.button);
        btnSave.setOnClickListener(v->{
            if(isValid()){
                intent=getIntent();
                ClubFitness c= null;
                try {
                    c = buildClubFromView();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Log.d("obiect adaugat cu succes",c.toString());
                intent.putExtra(key,c);
                setResult(RESULT_OK,intent);
                finish();
            }else{
                Toast.makeText(this,"eroare datele introduse nu respecta formatul",Toast.LENGTH_LONG).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private ClubFitness buildClubFromView() throws ParseException {
        String nume=tietNume.getText().toString().trim();
        String adresa=tietAdresa.getText().toString().trim();
        float pret=Float.parseFloat(tietPret.getText().toString());
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
        Date dat=sdf.parse(tietData.getText().toString());

        boolean esteNon=cbEsteNonStop.isChecked()?false:true;
        return new ClubFitness(nume,adresa,pret,dat,esteNon);
    }

    void init(){
        tietNume=findViewById(R.id.tiet_nume);
        tietAdresa=findViewById(R.id.tiet_adresa);
        tietPret=findViewById(R.id.tiet_pret);
        tietData=findViewById(R.id.tiet_dataDeschidere);
        cbEsteNonStop=findViewById(R.id.checkBox);



    }
    boolean isValid(){
        if(tietNume.getText().toString().length()<3||tietNume.getText()==null){
            return false;
        }
        if(tietAdresa.getText().toString().length()<3||tietAdresa.getText()==null){
            return false;
        }
        if(tietPret.getText().toString().length()<1||tietPret.getText()==null){
            return false;
        }
        if(tietData.getText().toString().length()<3||tietData.getText()==null){
            return false;
        }

        return true;
    }
}