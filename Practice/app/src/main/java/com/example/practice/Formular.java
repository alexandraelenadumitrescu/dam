package com.example.practice;



import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Formular extends AppCompatActivity {
    private Intent intent;

    public static final String SERIALIZABLE_OBJECT_KEY="SERIALIZABLE_OBJECT_KEY";
    private Button form_btn;
    private EditText form_ed_nume;
    private EditText form_ed_prenume;
    private EditText form_ed_email;
    private EditText form_ed_parola;

    private boolean isValid(){
        return true;
    }
    private Persoana buildSerializableObject(){
        //return new Persoana("Test ","prenumeTest","email@gmail.com","parola123");
        return new Persoana(form_ed_nume.getText().toString(),form_ed_prenume.getText().toString(),form_ed_email.getText().toString(),form_ed_parola.getText().toString());
    }


    @NonNull
    private View.OnClickListener getSaveClickListener(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isValid()){//verific daca utilizatorul a completat campurile necesare
                    Persoana object=buildSerializableObject();
                    //atasarea obiectului creat prin intent ul primit din mainactivity
                    intent.putExtra(SERIALIZABLE_OBJECT_KEY, object);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        };
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.formular);
        form_btn=findViewById(R.id.form_btn_trimite);
        form_ed_nume=findViewById(R.id.form_et_nume);
        form_ed_prenume=findViewById(R.id.form_et_prenume);
        form_ed_email=findViewById(R.id.form_et_email);
        form_ed_parola=findViewById(R.id.form_et_parola);

        //init comp
        intent=getIntent();
        form_btn.setOnClickListener(getSaveClickListener());
        //prel informatii din intent
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}