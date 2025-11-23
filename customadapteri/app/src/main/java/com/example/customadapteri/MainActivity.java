package com.example.customadapteri;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.customadapteri.domain.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar tb;
    Intent intent;
    ActivityResultLauncher<Intent> launcher;
    ArrayList<Student> studenti=new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.itadauga){
            intent=new Intent(getApplicationContext(), Formular.class);
            launcher.launch(intent);
        }
        if(item.getItemId()==R.id.itlista){
            intent=new Intent(getApplicationContext(),Lista.class);
            intent.putExtra("k",studenti);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.itlistaca){
            intent=new Intent(getApplicationContext(),ListaCA.class);
            intent.putExtra("k",studenti);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{
                if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                    Student s= (Student) result.getData().getSerializableExtra("K");
                    studenti.add(s);

                }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}