package com.example.dumitrescualexandraelena;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    private TextInputEditText tietNume;
    private TextInputEditText tietNumarInmatriculare;
    private TextInputEditText tietData;
    private TextInputEditText tietnrLocuri;
    private RadioGroup rgFunctional;
    private Button btnSave;
    Intent intent;
    public static final String TRAMVAI_KEY="tramvai_key";

//    setResult(RESULT_OK, intent) {
//
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        initComponents();
        //intent=getIntent();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void initComponents(){
        tietNume=findViewById(R.id.s_tiet_nume);
        tietNumarInmatriculare=findViewById(R.id.s_tiet_nrinm);
        tietData=findViewById(R.id.s_tiet_data);
        rgFunctional=findViewById(R.id.s_rg);
        tietnrLocuri=findViewById(R.id.s_tiet_nrlocuri);
        btnSave=findViewById(R.id.button);

            btnSave.setOnClickListener(v->{
                if(isValid()){
                    Tramvai tramvai= null;
                    try {
                        tramvai = buildObjectFromView();
//                        intent.putExtra(TRAMVAI_KEY,  tramvai);
//                        setResult(RESULT_OK,intent);
//                        finish();
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra(TRAMVAI_KEY,tramvai);
                            startActivity(intent);

                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    Log.i("adaugare",tramvai.toString());
                }
            });


    }

    private Tramvai buildObjectFromView() throws ParseException {
        String name=tietNume.getText().toString().trim();
        String nrInmatr=tietNumarInmatriculare.getText().toString().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date dat = sdf. parse(tietData.getText().toString());


        boolean funct=rgFunctional.getCheckedRadioButtonId()==R.id.s_rb_funct?true:false;
        int nrLocuri=Integer.parseInt(tietnrLocuri.getText().toString());

        return new Tramvai(name,nrInmatr,nrLocuri,dat,funct);
    }

    private boolean isValid(){
        if(tietNume.getText().toString().trim().length()<3||tietNume.getText()==null){
            Toast.makeText(this,"EROARE",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}