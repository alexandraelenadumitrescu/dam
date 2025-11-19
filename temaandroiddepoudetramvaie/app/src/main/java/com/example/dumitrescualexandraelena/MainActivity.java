package com.example.dumitrescualexandraelena;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar tb;

    private ListView lv;
    private List<Tramvai> tramvaie=new ArrayList<>();
    private ActivityResultLauncher<Intent> launcher;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        Intent intent;
        intent=getIntent();
        Tramvai t= (Tramvai) intent.getSerializableExtra(MainActivity2.TRAMVAI_KEY);
        tramvaie.add(t);
//
        lv=findViewById(R.id.lv);
        ArrayAdapter<Tramvai> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,tramvaie);
        lv.setAdapter(adapter);
        launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),getAddTramvaiCallBack());

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
        if(item.getItemId()==R.id.main_it1){
            Intent intent=new Intent(this, MainActivity2.class);
            //launcher.launch(intent);
            //startActivity(intent);
            launcher.launch(intent);
        }
        if(item.getItemId()==R.id.main_it2){
            Intent intent=new Intent(this, MainActivity3.class);
            intent.putExtra(MainActivity2.TRAMVAI_KEY,(ArrayList<Tramvai>) tramvaie);
            launcher.launch(intent);
        }
        return true;
    }
    private ActivityResultCallback<ActivityResult> getAddTramvaiCallBack() {
        return result->{
            if(result.getResultCode()==RESULT_OK&&result.getData()!=null){
                Tramvai t=(Tramvai) result.getData().getSerializableExtra(MainActivity2.TRAMVAI_KEY,Tramvai.class);
                Toast.makeText(this,t.toString(),Toast.LENGTH_LONG).show();
                tramvaie.add(t);
                ArrayAdapter<Tramvai> adapter=(ArrayAdapter<Tramvai>) lv.getAdapter();
                adapter.notifyDataSetChanged();
            }
        };
    }
}