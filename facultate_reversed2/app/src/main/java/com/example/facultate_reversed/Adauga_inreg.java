package com.example.facultate_reversed;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Adauga_inreg extends AppCompatActivity {

    Button btnSave;
    ActivityResultLauncher<Intent> launcher;
    TextInputEditText tiet_nume;
    Spinner spn;
    TextInputEditText tiet_cod;
    TextInputEditText tiet_data;
    CheckBox cb;
    Intent intent;
    public static final String key="key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnSave=findViewById(R.id.button);
        initializare();
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{

        });
        btnSave.setOnClickListener(v->{
            if(isValid()){
                try {
                    Facultate f=buildFromView();
                    intent=new Intent(getApplicationContext(), Lista_inreg.class);
                    intent.putExtra(key,f);
                    setResult(RESULT_OK);
                    launcher.launch(intent);
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

    private Facultate buildFromView() throws ParseException {
        Tip_invatamant tip;
        if(spn.getSelectedItem().toString().equals("ir")){
            tip=Tip_invatamant.IR;
        }else{
        tip=Tip_invatamant.ID;}
        String nume=tiet_nume.getText().toString().trim();
        int cod=Integer.parseInt(tiet_cod.getText().toString());
        boolean esteStat= cb.isChecked();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date dat= sdf.parse(tiet_data.getText().toString());
        return new Facultate(tip,nume,cod,dat,esteStat);
    }

    private void initializare() {
        tiet_nume=findViewById(R.id.tiet_nume);
        tiet_cod=findViewById(R.id.tiet_cod);
        tiet_data=findViewById(R.id.tiet_data);
        spn=findViewById(R.id.spinner);
        cb=findViewById(R.id.checkBox);

    }

    private boolean isValid() {
        if(tiet_nume.getText()==null||tiet_nume.getText().toString().trim().length()<3){
            return false;
        }
        if(tiet_data.getText()==null||tiet_data.getText().toString().trim().length()<3){
            return false;
        }
        if(tiet_cod.getText()==null||tiet_cod.getText().toString().trim().length()<3){
            return false;
        }
        return true;

    }
}