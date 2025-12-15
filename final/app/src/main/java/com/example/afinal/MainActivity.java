package com.example.afinal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        BazaDate bd= Room.databaseBuilder(this, BazaDate.class,"bd").build();
        Button btnSave=findViewById(R.id.btn_save);
        Button btnDelete=findViewById(R.id.btn_delete);
        Button btnLoad=findViewById(R.id.btn_load);
        EditText ed1=findViewById(R.id.ed1);
        EditText ed2=findViewById(R.id.ed2);
        EditText ed3=findViewById(R.id.ed3);
        btnSave.setOnClickListener(v->{
            new Thread(()->{
                Cursa c=new Cursa(0,Integer.parseInt(ed1.getText().toString()),ed2.getText().toString(),true);
                bd.cursaDao().add(c);
            }).start();
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}