package com.example.parsarejson;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    EditText ed;
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
        ed=findViewById(R.id.ed);
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
        btnLoad.setOnClickListener(v -> {
            // 1. Extragem lista din baza de date
            // (Asigură-te că importi java.util.List)
            java.util.List<Cursa> listaDinDb = db.persoanaDao().getAll();

            // 2. Construim un text lung care să conțină toate rândurile
            StringBuilder builder = new StringBuilder();

            if (listaDinDb.isEmpty()) {
                builder.append("Nu există curse în baza de date.");
            } else {
                for (Cursa c : listaDinDb) {
                    builder.append("ID: ").append(c.getId())
                            .append(" - ").append(c.getDestinatie())
                            .append(" (").append(c.getDistanta()).append(" km)")
                            .append("\n"); // "\n" trece la rând nou
                }
            }

            // 3. Afișăm tot textul în tiet2 (sau alt EditText dedicat afișării)
            ed.setText(builder.toString());
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}