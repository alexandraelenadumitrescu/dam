package com.example.frameshuttr;

public class ma {
    /*
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

public class MainActivity extends AppCompatActivity {

    private NodeEditorView editorView;
    private ImageView previewImage;
    private Button btnProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Asigură-te că ai layout-ul XML

        // Setup UI
        editorView = findViewById(R.id.nodeEditor); // Trebuie definit în XML
        previewImage = findViewById(R.id.resultImage);
        btnProcess = findViewById(R.id.btnProcess);

        // 1. Creăm Nodurile
        SourceNode source = new SourceNode("1", 100, 100);
        CullingNode culling = new CullingNode("2", 500, 200);
        StyleTransferNode style = new StyleTransferNode("3", 900, 100);

        // 2. Le adăugăm în View
        editorView.addNode(source);
        editorView.addNode(culling);
        editorView.addNode(style);

        // 3. Creăm Conexiunile (Fluxul: Source -> Culling -> Style)
//        editorView.connectNodes(source, culling);
//        editorView.connectNodes(culling, style);

        // 4. Butonul de procesare
        btnProcess.setOnClickListener(v -> {
            // Încărcăm o imagine dummy din resurse
            Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.img);

            // Executăm fluxul pe un thread secundar (Important pt Android!)
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
     */
}
