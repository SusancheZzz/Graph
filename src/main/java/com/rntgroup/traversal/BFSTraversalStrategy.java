package com.rntgroup.traversal;

import com.rntgroup.graph.GraphNode;
import com.rntgroup.visitor.Visitor;

import java.util.LinkedList;
import java.util.Queue;


public class BFSTraversalStrategy implements TraversalStrategy {

    @Override
    public void traverse(GraphNode root, Visitor visitor) {

        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            visitor.visit(node);
            queue.addAll(node.getChildren());
        }
    }
}
