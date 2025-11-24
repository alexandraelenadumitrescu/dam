package com.example.frameshuttr.domain.nodes;

import java.util.ArrayList;
import java.util.List;

public class NodeGraph {//TIN DATELE LEGATE DE NODURI SI CONEXIUNI
    private List<Node> nodes=new ArrayList<>();


    public void addNode(Node node) {
        nodes.add(node);

    }
    public void removeNode(Node node) {
        // Deconectează toate legăturile
        for (Node n : nodes) {
            if (n.outputNode == node) {
                n.outputNode = null;
            }
            n.inputs.remove(node);
        }
        nodes.remove(node);
    }




}
