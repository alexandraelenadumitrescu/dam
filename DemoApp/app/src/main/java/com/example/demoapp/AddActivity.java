package com.example.demoapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demoapp.domain.DateConverter;
import com.example.demoapp.domain.Student;
import com.example.demoapp.domain.StudyType;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

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
            if(isValid()){
                Student student=buildStudentFromView();
                Log.i("AddActivity","Students= "+student);
            }
            //validam datele de la tastatura

        });
    }

    private Student buildStudentFromView() {
        String name=tietName.getText().toString();
        Date enrollmentDate=DateConverter.toDate(tietEnrollmentDate.getText().toString());
        String faculty=(String)spnFaculty.getSelectedItem();
        StudyType studyType=rgStudyType.getCheckedRadioButtonId()==R.id.add_rb_full_time? StudyType.FULL_TIME:StudyType.DISTANCE;

        return new Student(name,enrollmentDate,faculty,studyType);
    }

    private boolean isValid(){
        if(tietName.getText()==null || tietName.getText().length()<3){
            Toast.makeText(this, R.string.add_invalid_name_minimum_3_characters,Toast.LENGTH_LONG ).show();
            return false;
        }
        if(tietEnrollmentDate.getText()==null || DateConverter.toDate(tietEnrollmentDate.getText().toString())==null){
            Toast.makeText(this, R.string.add_invalid_enrollment_date_accepted_format_dd_mm_yyyy,Toast.LENGTH_LONG ).show();

            return false;
        }
        return true;

    }

}