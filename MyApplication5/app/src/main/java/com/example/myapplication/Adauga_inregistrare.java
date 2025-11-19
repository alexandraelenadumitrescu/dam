package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Adauga_inregistrare extends AppCompatActivity {
    Intent intent;
    TextInputEditText tietNume;
    TextInputEditText tietAdresa;
    TextInputEditText tietData;

    TextInputEditText tietCod;
    CheckBox cbStat;
    Button btnSave;
    public static final String key="key";

    Facultate f;
    ActivityResultLauncher<Intent> launcher;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_inregistrare);
        init();
        intent=getIntent();
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result->{
            if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                Facultate f=result.getData().getSerializableExtra(Adauga_inregistrare.key,Facultate.class);
                tietData.setText(f.getDate().toString());
                tietAdresa.setText(f.getAdresa().toString());
                tietCod.setText(f.getCod());
                tietNume.setText(f.getNume().toString());
                cbStat.setChecked(f.isEsteDeStat());


            }
        });

        btnSave=findViewById(R.id.button);
        btnSave.setOnClickListener(v->{
            try {
                if(isValid()){
                Facultate f=buildFromView();
                intent=getIntent();
                intent.putExtra(key,f);
                setResult(RESULT_OK,intent);
                finish();
                }else{
                    Toast.makeText(this,"datele introduse nu respecta formatul acceptat",Toast.LENGTH_LONG).show();
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private boolean isValid() {
        if(tietNume.getText()==null||tietNume.getText().toString().trim().length()<2){
            return false;
        }
        if(tietCod.getText()==null){
            return false;
        }
        if(tietAdresa.getText()==null||tietAdresa.getText().toString().trim().length()<3){
            return false;
        }
        if(tietData.getText()==null||tietData.getText().toString().trim().length()<3){
            return false;
        }
        return true;
    }

    private Facultate buildFromView() throws ParseException {
        int cod=Integer.parseInt(tietCod.getText().toString().trim());
        String adresa=tietAdresa.getText().toString().trim();
        String nume=tietNume.getText().toString().trim();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date dat=sdf.parse(tietData.getText().toString());
        boolean esteStat=cbStat.isChecked()?false:true;
        return new Facultate(cod,nume,adresa,dat,esteStat);
    }


    void init(){
        tietNume=findViewById(R.id.tiet_nume);
        tietAdresa=findViewById(R.id.tiet_adresa);
        tietCod=findViewById(R.id.tiet_cod);
        tietData=findViewById(R.id.tiet_data);
        cbStat=findViewById(R.id.checkBox);
    }
}