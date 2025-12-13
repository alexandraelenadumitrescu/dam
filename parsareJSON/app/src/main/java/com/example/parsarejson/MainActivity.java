package com.example.parsarejson;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    Button btnLoad;
    Button btnDelete;
    TextInputEditText tiet1;
    TextInputEditText tiet2;
    ArrayList<Cursa> curse=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnSave=findViewById(R.id.btn_save);
        btnLoad=findViewById(R.id.btn_load);
        btnDelete=findViewById(R.id.btn_delete);
        tiet1=findViewById(R.id.tiet1);
        tiet2=findViewById(R.id.tiet2);
        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "nume-baza")
                .allowMainThreadQueries() // TRUCUL MAGIC: Scapi de Thread-uri!
                .build();
        btnSave.setOnClickListener(v->{
            String t1=tiet1.getText().toString();
            String t2=tiet2.getText().toString();
            Cursa c=new Cursa(0,t2,Integer.parseInt(t1),false);
            curse.add(c);
            db.persoanaDao().insert(curse);


        });
        System.out.println(db.persoanaDao());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}