package com.example.final2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar tb;
    BazaDate bd;
    EditText ed;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        bd= Room.databaseBuilder(this, BazaDate.class,"bd").build();
        ed=findViewById(R.id.ed);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.it1){
            new Thread(()->{
                bd.cursaDao().add(new Cursa(0,100,"Galati",true));
                StringBuilder sb=new StringBuilder();
                List<Cursa> curse=bd.cursaDao().getAll();
                for( Cursa c : curse){
                    sb.append(c.toString());
                }
                runOnUiThread(()->{
                    ed.setText(sb.toString());
                });
            }).start();

        }
        return super.onOptionsItemSelected(item);
    }
}