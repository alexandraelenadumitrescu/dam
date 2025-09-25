package com.example.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

fabAdd=findViewById(R.id.main_fab_add);
fabAdd.setOnClickListener(v->{
    Intent intent=new Intent(getApplicationContext(),AddActivity.class);
    startActivity(intent);
});
    }
}

//fabAdd=findViewById(R.id.main_fab_add);
//fabAdd.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        //v.getId();//=>returneaza R.id.main_fab_add de la ce buton s a declansat, daca implementam la nivelul clasei mainactivity view.onclicklistener o sg impl de clcik pt toate butoanele din interfata, nu se recomanda,mai ok inline sau anonim
//    }
//});
//    }
//}