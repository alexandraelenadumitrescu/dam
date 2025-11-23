package com.example.customadapteri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.customadapteri.domain.Student;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formular extends AppCompatActivity {
    Button btnSave;
    TextInputEditText tietnume;
    TextInputEditText tietdata;
    TextInputEditText tietcredite;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formular);
        initializare();
        btnSave.setOnClickListener(v -> {
            if(valid()){
                try {
                    Student s=buildObjectFromView();
                    intent=getIntent();
                    intent.putExtra("K",s);
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

    private Student buildObjectFromView() throws ParseException {
        String nume=tietnume.getText().toString();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date dat=sdf.parse(tietdata.getText().toString());
        int nr=Integer.parseInt(tietcredite.getText().toString());
        return new Student(nume,dat,nr);
    }

    private boolean valid() {
        if(tietnume.getText().toString().length()<3){
            return false;
        }
        if(tietdata.getText().toString().length()<3){
            return false;
        }
        if(tietcredite.getText().toString().length()<1){
            return false;
        }
        return true;
    }

    private void initializare() {
        btnSave=findViewById(R.id.btnSave);
        tietnume=findViewById(R.id.tiet_nume);
        tietdata=findViewById(R.id.tiet_data);
        tietcredite=findViewById(R.id.tiet_nrcredite);
    }
}