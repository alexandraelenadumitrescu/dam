package com.example.test2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.test2.domain.DateConverter;
import com.example.test2.domain.Enumeratie;
import com.example.test2.domain.Obiect;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private TextInputEditText tiet1;
    private TextInputEditText tiet2;
    private Spinner spn;
    private RadioGroup rg1;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initComponents();
    }
    private void initComponents(){
        tiet1=findViewById(R.id.s_tiet_nume);
        tiet2=findViewById(R.id.s_tiet_data);
        spn=findViewById(R.id.spn);
        rg1=findViewById(R.id.s_rg);
        bt=findViewById(R.id.button);
        bt.setOnClickListener(
                v->{if(isValid()){

                Obiect ob=createObjectFromView();
            Log.i("Haide", "OB:" + ob);


        }});


    }

    private Obiect createObjectFromView() {
        String s1=tiet1.getText().toString();
        String sp1=spn.getSelectedItem().toString();
        Enumeratie e=rg1.getCheckedRadioButtonId()==R.id.rb1? Enumeratie.ENUM1:Enumeratie.ENUM2;
        Date d=DateConverter.toDate(tiet2.getText().toString());
        return new Obiect(s1,d,e,sp1);
    }

    private boolean isValid(){
        if(tiet1.getText()==null|| tiet1.getText().toString().trim().length()<3){
            Toast.makeText(this,"EROARE", Toast.LENGTH_LONG).show();
            return false;
        }
        if(tiet2.getText()==null|| DateConverter.toDate(tiet2.getText().toString())==null){
            Toast.makeText(this,"EROARE", Toast.LENGTH_LONG).show();

            return false;
        }
        return true;
    }
}