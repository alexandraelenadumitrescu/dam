package com.example.frameshuttr.domain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.frameshuttr.domain.nodes.Node;
import com.example.frameshuttr.domain.nodes.NodeType;

import java.util.ArrayList;
import java.util.List;

public class NodeEditorView extends View {

    private List<Node> nodes = new ArrayList<>();

    private Paint nodeBodyPaint, nodeHeaderPaint, textPaint, linePaint, gridPaint, portPaint;//
    private Node selectedNode = null;
    private float lastTouchX, lastTouchY;


    private static final int CORNER_RADIUS = 15;
    private static final int PORT_RADIUS = 12;
    private static final int GRID_SPACING = 60;

    public NodeEditorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // corp nod -gri, squircle
        nodeBodyPaint = new Paint();
        nodeBodyPaint.setColor(Color.parseColor("#333333"));
        nodeBodyPaint.setStyle(Paint.Style.FILL);
        nodeBodyPaint.setShadowLayer(12, 0, 0, Color.BLACK); // Umbră
        nodeBodyPaint.setAntiAlias(true);

        // header
        nodeHeaderPaint = new Paint();
        nodeHeaderPaint.setStyle(Paint.Style.FILL);
        nodeHeaderPaint.setAntiAlias(true);

        // text
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(32); // Mai finuț
        textPaint.setFakeBoldText(true);
        textPaint.setAntiAlias(true);

        // conexiuni
        linePaint = new Paint();
        linePaint.setColor(Color.parseColor("#AAAAAA"));
        linePaint.setStrokeWidth(6);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setAntiAlias(true);

        // grid
        gridPaint = new Paint();
        gridPaint.setColor(Color.parseColor("#444444"));
        gridPaint.setStrokeWidth(3);

        // intrari
        portPaint = new Paint();
        portPaint.setColor(Color.WHITE);
        portPaint.setStyle(Paint.Style.FILL);
        portPaint.setAntiAlias(true);//fara zimti

        // Activăm accelerarea hardware pentru umbre
        setLayerType(LAYER_TYPE_SOFTWARE, nodeBodyPaint);
    }

    public void addNode(Node node) {
        nodes.add(node);
        invalidate();
    }

    public void connectNodes(Node from, Node to) {
        from.outputNode = to;
        to.inputs.add(from);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#181818")); // Fundal foarte închis (n8n style)

        drawGrid(canvas);

        // 1. Desenăm conexiunile PRIMA DATĂ (ca să fie sub noduri)
        for (Node node : nodes) {
            if (node.outputNode != null) {
                drawConnection(canvas, node, node.outputNode);
            }
        }

        // 2. Desenăm nodurile
        for (Node node : nodes) {
            drawFancyNode(canvas, node);
        }
    }

    private void drawGrid(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < width; i += GRID_SPACING) {
            for (int j = 0; j < height; j += GRID_SPACING) {
                canvas.drawPoint(i, j, gridPaint);
            }
        }
    }

    private void drawFancyNode(Canvas canvas, Node node) {
        RectF r = node.position;

        // A. Desenăm corpul (Card)
        canvas.drawRoundRect(r, CORNER_RADIUS, CORNER_RADIUS, nodeBodyPaint);

        // B. Desenăm Header-ul colorat (O bandă mică sus sau stânga)
        // Aici facem o bandă verticală în stânga, stil modern
        nodeHeaderPaint.setColor(getNodeColor(node.type));
        // Clipim doar partea stângă
        RectF headerRect = new RectF(r.left, r.top, r.left + 15, r.bottom);
        // Desenăm un dreptunghi rotunjit doar pe stânga (truc vizual simplu)
        canvas.drawRoundRect(headerRect, CORNER_RADIUS, CORNER_RADIUS, nodeHeaderPaint);
        // Acoperim colțurile drepte ale headerului pentru a le face drepte spre interior
        canvas.drawRect(r.left + 8, r.top, r.left + 15, r.bottom, nodeHeaderPaint);

        // C. Desenăm Titlul
        canvas.drawText(node.title, r.left + 35, r.centerY() + 10, textPaint);

        // D. Desenăm Porturile (Cercurile de conexiune)
        // Input Port (Stânga) - nu desenăm pentru SOURCE
        if (node.type != NodeType.SOURCE) {
            canvas.drawCircle(r.left, r.centerY(), PORT_RADIUS, portPaint);
            canvas.drawCircle(r.left, r.centerY(), PORT_RADIUS - 4, nodeBodyPaint); // Gaură în mijloc
        }

        // Output Port (Dreapta)
        canvas.drawCircle(r.right, r.centerY(), PORT_RADIUS, portPaint);
    }

    private void drawConnection(Canvas canvas, Node start, Node end) {
        Path path = new Path();

        // Coordonate exacte de la portul de ieșire la cel de intrare
        float startX = start.position.right;
        float startY = start.position.centerY();
        float endX = end.position.left;
        float endY = end.position.centerY();

        path.moveTo(startX, startY);

        // Logică Bezier n8n: Control points sunt orizontale
        float controlPointX1 = startX + 150; // Trage firul spre dreapta
        float controlPointX2 = endX - 150;   // Trage firul din stânga

        path.cubicTo(controlPointX1, startY, controlPointX2, endY, endX, endY);

        canvas.drawPath(path, linePaint);
    }

    private int getNodeColor(NodeType type) {
        // Culori vibrante pe fundal închis
        switch (type) {
            case SOURCE: return Color.parseColor("#00E676"); // verde menta
            case AI_CULLING: return Color.parseColor("#FF4081"); // roz-rosu
            case AI_STYLE_TRANSFER: return Color.parseColor("#448AFF"); // albastru senin
            default: return Color.parseColor("#FFAB00"); // chihlimbar
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Inversăm lista la iterare pentru a selecta nodul de deasupra (z-index)
                for (int i = nodes.size() - 1; i >= 0; i--) {
                    Node node = nodes.get(i);
                    if (node.position.contains(x, y)) {
                        selectedNode = node;
                        lastTouchX = x;
                        lastTouchY = y;
                        // Mutăm nodul selectat la finalul listei (să fie desenat ultimul/deasupra)
                        nodes.remove(i);
                        nodes.add(node);
                        invalidate();
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

    public Bitmap executePipeline(Bitmap startImage) {
        Node startNode = null;
        for(Node n : nodes) {
            if(n.type == NodeType.SOURCE) {
                startNode = n;
                break;
            }
        }
        if (startNode == null) return null;
        return processNodeRecursively(startNode, startImage);
    }

    private Bitmap processNodeRecursively(Node currentNode, Bitmap image) {
        if (currentNode == null || image == null) return image;
        Bitmap processedImage = currentNode.process(image);
        return processNodeRecursively(currentNode.outputNode, processedImage);
    }
}