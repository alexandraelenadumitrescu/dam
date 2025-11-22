package com.example.frameshuttr.domain.nodes;

public class nev {
    /*package com.example.frameshuttr.domain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.frameshuttr.domain.nodes.Node;
import com.example.frameshuttr.domain.nodes.NodeType;

import java.util.ArrayList;
import java.util.List;

public class NodeEditorView extends View {
    private List<Node> nodes = new ArrayList<>();
    private Paint nodePaint, textPaint, linePaint;
    private Node selectedNode = null;
    private float lastTouchX, lastTouchY;

    public NodeEditorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        nodePaint = new Paint();
        nodePaint.setColor(Color.DKGRAY);
        nodePaint.setStyle(Paint.Style.FILL);
        nodePaint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(40);
        textPaint.setAntiAlias(true);

        linePaint = new Paint();
        linePaint.setColor(Color.CYAN);
        linePaint.setStrokeWidth(5);
        linePaint.setStyle(Paint.Style.STROKE);
    }

    public void addNode(Node node) {
        nodes.add(node);
        invalidate(); // Redesenează
    }

    // Conectează două noduri (Simplificat: Node A -> Node B)
    public void connectNodes(Node from, Node to) {
        from.outputNode = to;
        to.inputs.add(from);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#1e1e1e")); // Fundal închis

        // 1. Desenăm conexiunile (Linii curbe)
        for (Node node : nodes) {
            if (node.outputNode != null) {
                drawConnection(canvas, node, node.outputNode);
            }
        }

        // 2. Desenăm nodurile
        for (Node node : nodes) {
            // Corpul nodului
            nodePaint.setColor(getNodeColor(node.type));
            canvas.drawRoundRect(node.position, 20, 20, nodePaint);

            // Titlul nodului
            canvas.drawText(node.title, node.position.left + 20, node.position.centerY(), textPaint);
        }
    }

    private void drawConnection(Canvas canvas, Node start, Node end) {
        Path path = new Path();
        float startX = start.position.right;
        float startY = start.position.centerY();
        float endX = end.position.left;
        float endY = end.position.centerY();

        path.moveTo(startX, startY);
        // Curbă Bezier pentru estetică
        path.cubicTo((startX + endX) / 2, startY, (startX + endX) / 2, endY, endX, endY);

        canvas.drawPath(path, linePaint);
    }

    private int getNodeColor(NodeType type) {
        switch (type) {
            case SOURCE: return Color.parseColor("#4CAF50"); // Green
            case AI_CULLING: return Color.parseColor("#F44336"); // Red
            case AI_STYLE_TRANSFER: return Color.parseColor("#2196F3"); // Blue
            default: return Color.GRAY;
        }
    }

    // Logică simplă de Drag & Drop
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (Node node : nodes) {
                    if (node.position.contains(x, y)) {
                        selectedNode = node;
                        lastTouchX = x;
                        lastTouchY = y;
                        return true;
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (selectedNode != null) {
                    float dx = x - lastTouchX;
                    float dy = y - lastTouchY;
                    selectedNode.position.offset(dx, dy);
                    lastTouchX = x;
                    lastTouchY = y;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                selectedNode = null;
                break;
        }
        return true;
    }

    // Metodă pentru a rula fluxul (Pipeline)
    public Bitmap executePipeline(Bitmap startImage) {
        // Căutăm nodul sursă
        Node startNode = null;
        for(Node n : nodes) {
            if(n.type == NodeType.SOURCE) {
                startNode = n;
                break;
            }
        }

        if (startNode == null) return null;

        // Procesare recursivă
        return processNodeRecursively(startNode, startImage);
    }

    private Bitmap processNodeRecursively(Node currentNode, Bitmap image) {
        if (currentNode == null || image == null) return image;

        // Procesează imaginea în nodul curent
        Bitmap processedImage = currentNode.process(image);

        // Trimite la următorul nod
        return processNodeRecursively(currentNode.outputNode, processedImage);
    }
}*/
}
