package com.example.test_recap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Adauga extends AppCompatActivity {
    public static final String key="k";
    Button btn;
    TextInputEditText tietData;
    TextInputEditText tietNume;
    TextInputEditText tietSportivi;
    Spinner spn;
    TextInputEditText tietnRfACIL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga);
        Intent intent=getIntent();
        intializare();
        btn=findViewById(R.id.button3);
        btn.setOnClickListener(v->{
            if (valid()) {
                try {
                    intent.putExtra(key,buildFromView());
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

    private ClubSportiv buildFromView() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date date=sdf.parse(tietData.getText().toString());
        String nume=tietNume.getText().toString().trim();
        int nrSpo=Integer.parseInt(tietSportivi.getText().toString());
        String adresa=spn.getSelectedItem().toString();
        int nrF=Integer.parseInt(tietnRfACIL.getText().toString());
        return new ClubSportiv(date,nume,adresa,nrSpo,nrF);
    }

    private void intializare() {
        tietData=findViewById(R.id.tiet_data);
        tietNume=findViewById(R.id.tiet_nume);
        tietSportivi=findViewById(R.id.tiet_nrSportivi);
        spn=findViewById(R.id.spn);
        tietnRfACIL=findViewById(R.id.tiet_nrfacil);

    }

    private boolean valid() {
        if(tietData.getText()==null||tietData.getText().toString().trim().length()<2){
            Toast.makeText(this,"eroare",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}