package com.example.dumitrescualexandraelena;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private ListView lv;
    private List<Tramvai> tramvaie=new ArrayList<>();
    private ActivityResultLauncher<Intent> launcher;
    ArrayList<Tramvai> tramvais=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        lv=findViewById(R.id.lv3);

        Intent intent=getIntent();
        tramvais=intent.getSerializableExtra(MainActivity2.TRAMVAI_KEY,ArrayList.class);
        ArrayAdapter<Tramvai> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,tramvais
        );
        lv.setAdapter(adapter);
//        if(intent!=null&&intent.hasExtra(MainActivity2.TRAMVAI_KEY)){
//            Tramvai t= (Tramvai) intent.getSerializableExtra(MainActivity2.TRAMVAI_KEY);
//            tramvais.add(t);
//            adapter.notifyDataSetChanged();
//        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private ActivityResultCallback<ActivityResult> getAddTramvaiCallBack() {
    return null;
    }
}