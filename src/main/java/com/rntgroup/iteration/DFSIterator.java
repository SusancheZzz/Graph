package com.rntgroup.iteration;

import com.rntgroup.graph.GraphNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DFSIterator implements Iterator<GraphNode> {

    private final Deque<GraphNode> stack = new ArrayDeque<>();

    public DFSIterator(GraphNode root) {
        Objects.requireNonNull(root);
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public GraphNode next() {
        if (!hasNext()) throw new NoSuchElementException();

        GraphNode node = stack.pop();
        List<GraphNode> children = node.getChildren();
        for (int i = children.size() - 1; i > -1; i--) {
            stack.push(children.get(i));
        }
        return node;
    }
}
