package com.example.frameshuttr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.frameshuttr.domain.nodes.CullingNode;
import com.example.frameshuttr.domain.NodeEditorView;
import com.example.frameshuttr.domain.nodes.SourceNode;
import com.example.frameshuttr.domain.nodes.StyleTransferNode;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private NodeEditorView editorView;
    private ImageView previewImage;
    private FloatingActionButton btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // todo mutat intr un init sau intr o alta activitate daca e predefinit
        editorView = findViewById(R.id.nodeEditor);
        previewImage = findViewById(R.id.resultImage);
        btnProcess = findViewById(R.id.btnProcess);


        SourceNode source = new SourceNode("1", 100, 100);
        CullingNode culling = new CullingNode("2", 500, 200);
        StyleTransferNode style = new StyleTransferNode("3", 900, 100);

        //todo de adaugat din interfata nu doar din cod
        editorView.addNode(source);
        editorView.addNode(culling);
        editorView.addNode(style);


        editorView.connectNodes(source, culling);
        editorView.connectNodes(culling, style);

        // procesare
        btnProcess.setOnClickListener(v -> {
            // incarc o imagine de test din res drawable
            Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.img);

            // execut pe thread secundar
            new Thread(() -> {
                Bitmap result = editorView.executePipeline(original);

                runOnUiThread(() -> {
                    if (result != null) {
                        previewImage.setImageBitmap(result);
                    }
                });
            }).start();
        });
    }
}