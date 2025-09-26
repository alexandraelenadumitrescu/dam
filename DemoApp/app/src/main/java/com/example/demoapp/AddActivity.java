package com.example.demoapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class AddActivity extends AppCompatActivity {

    private TextInputEditText tietName;
    private TextInputEditText tietEnrollmentDate;

    private Spinner spnFaculty;
    private RadioGroup rgStudyType;
    private Button btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initComponents();

    }
    private void initComponents(){
        tietName=findViewById(R.id.add_tiet_name);
        tietEnrollmentDate=findViewById(R.id.add_tiet_enrollment_date);
        spnFaculty=findViewById(R.id.add_spn_faculty);
        rgStudyType=findViewById(R.id.add_rg_study_type);
        btSave=findViewById(R.id.add_bt_save);
        btSave.setOnClickListener(v->{
            //ne aflam dupa apasarea butonului save
            //validam datele de la tastatura

        });
    }
}