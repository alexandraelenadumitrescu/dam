package com.example.frameshuttr.domain.nodes;

import android.graphics.Bitmap;

public class CullingNode extends Node {
    public CullingNode(String id, float x, float y) {
        super(id, "AI Culling (Blur Check)", NodeType.AI_CULLING, x, y);
    }

    @Override
    public Bitmap process(Bitmap inputImage) {
        if (inputImage == null){ return null;}
        System.out.println("ai culling"+inputImage.toString());
        return inputImage;

    }
}
