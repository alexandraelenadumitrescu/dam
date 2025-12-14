package com.example.curse;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnSave;
    Button btnLoad;
    Button btnDelete;
    EditText ed1;
    EditText ed2;
    EditText edAfis;
    ArrayList<Cursa> curse=new ArrayList<>();
    private CursaDao cursaDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Db db= Room.databaseBuilder(this,Db.class,"curse").build();
        this.cursaDao=db.cursaDao();
        setContentView(R.layout.activity_main);
        btnDelete=findViewById(R.id.btn_delete);
        btnLoad=findViewById(R.id.btn_load);
        btnSave=findViewById(R.id.btn_save);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        edAfis=findViewById(R.id.ed_afis);
        btnSave.setOnClickListener(v->{
            String dest=ed1.getText().toString();
            int dist=Integer.parseInt(ed2.getText().toString());
            Cursa c=new Cursa(0,false,dest,dist);
            Db.dbWriteExec.execute(()->{

                cursaDao.insert(c);
            });
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}