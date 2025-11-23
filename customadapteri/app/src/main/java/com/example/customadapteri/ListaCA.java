package com.example.customadapteri;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.customadapteri.domain.Student;
import com.example.customadapteri.domain.StudentAdapter;

import java.util.ArrayList;

public class ListaCA extends AppCompatActivity {
    ListView lv;
    ArrayList<Student> studenti=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_ca);
        lv=findViewById(R.id.lv_ca);
        studenti=getIntent().getSerializableExtra("k",ArrayList.class);
        StudentAdapter adapter=new StudentAdapter(this,R.layout.lv_row,studenti,getLayoutInflater());
        lv.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}