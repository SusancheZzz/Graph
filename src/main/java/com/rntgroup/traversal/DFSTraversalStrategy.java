package com.rntgroup.traversal;

import com.rntgroup.graph.GraphNode;
import com.rntgroup.visitor.Visitor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DFSTraversalStrategy implements TraversalStrategy {
    @Override
    public void traverse(GraphNode root, Visitor visitor) {

        Deque<GraphNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            visitor.visit(node);
            List<GraphNode> children = node.getChildren();
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
    }
}
