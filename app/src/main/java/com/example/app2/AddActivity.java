package com.example.app2;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class AddActivity extends AppCompatActivity {
    private TextInputEditText add_tiet_nume;
    private TextInputEditText add_tiet_prenume;
    private TextInputEditText add_tiet_data;
    private Spinner add_spn_tip_client;
    private RadioGroup add_rg;


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
    }
    private void initComponents(){
        add_tiet_data=findViewById(R.id.add_date);
        add_tiet_nume=findViewById(R.id.add_tiet_nume);
        add_tiet_prenume=findViewById(R.id.add_tiet_prenume);
        add_rg=findViewById(R.id.add_rg);
        add_spn_tip_client=findViewById(R.id.add_spn);
    }
    boolean isValid(){
        return true;
    }

}