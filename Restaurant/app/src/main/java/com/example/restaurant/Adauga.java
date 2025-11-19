package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Adauga extends AppCompatActivity {
    Button btnSave;

    Intent intent;
    public final static String k="k";
    TextInputEditText tietNrScaune;
    TextInputEditText tietNume;
    TextInputEditText tietData;
    TextInputEditText tietAdresa;
    RadioButton rbVegan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga);
        intent=getIntent();
        btnSave=findViewById(R.id.button_save);
        initializare();
        btnSave.setOnClickListener(v->{
            if(isValid()){
                try {
                    intent.putExtra(k,buildFromView());
                    setResult(RESULT_OK,intent);
                    finish();

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private Restaurant buildFromView() throws ParseException {
        String adresa=tietAdresa.getText().toString().trim();
        String nume=tietNume.getText().toString().trim();
        Integer nrScaune=Integer.parseInt(tietNrScaune.getText().toString());
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date dat=sdf.parse(tietData.getText().toString());
        boolean esteVegan=rbVegan.isChecked();
        return new Restaurant(nrScaune,nume,esteVegan,dat,adresa);

    }

    private void initializare() {
        tietAdresa=findViewById(R.id.tiet_adresa);
        tietNrScaune=findViewById(R.id.tiet_nrScaune);
        tietData=findViewById(R.id.tiet_data);
        tietNume=findViewById(R.id.tiet_nume);
        rbVegan=findViewById(R.id.radioButton);
    }

    private boolean isValid() {
        if(tietAdresa.getText()==null||tietAdresa.getText().toString().trim().length()<3){
            return false;
        }
        if(tietNrScaune.getText()==null){
            return false;
        }
        if(tietData.getText()==null||tietData.getText().toString().trim().length()<3){
            return false;
        }if(tietNume.getText()==null){
            return false;
        }


        return true;
    }
}