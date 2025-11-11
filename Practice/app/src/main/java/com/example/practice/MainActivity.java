package com.example.practice;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private Button main_btn;
    private FloatingActionButton main_fab;

    private ActivityResultLauncher activityResultLauncher;
    ActivityResultContracts.StartActivityForResult contract=new ActivityResultContracts.StartActivityForResult();
    ActivityResultCallback<ActivityResult> callback=new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                //procesam informatiile din result.getData(Intent) care au fost trimise din second activity

            }
        }
    };
    @NonNull
    private View.OnClickListener getOnClickListener(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Formular.class);
                //pornire activitate secundara
                //adaugare inf extra daca e cazul
                //intent.putExtra("KEY",value);
                activityResultLauncher.launch(intent);

            }


        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        main_btn=findViewById(R.id.main_btn);
        main_fab=findViewById(R.id.main_fab);
        main_btn.setOnClickListener(v-> Log.d("TAG","a fost apasat butonul"));

        Log.d("TAG","a pornit aplicatia");
//        main_fab.setOnClickListener(v -> {
//            Intent intent=new Intent(getApplicationContext(), Formular.class);
//            startActivity(intent);
//        });

        //
        activityResultLauncher=registerForActivityResult(contract,callback);
        main_fab.setOnClickListener(getOnClickListener());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}