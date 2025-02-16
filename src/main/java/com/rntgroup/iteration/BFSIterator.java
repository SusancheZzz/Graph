package com.rntgroup.iteration;

import com.rntgroup.graph.GraphNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

public class BFSIterator implements Iterator<GraphNode> {

    private final Queue<GraphNode> queue = new LinkedList<>();

    public BFSIterator(GraphNode root) {
        Objects.requireNonNull(root);
        queue.add(root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public GraphNode next() {
        if (!hasNext()) throw new NoSuchElementException();

        GraphNode node = queue.poll();
        Objects.requireNonNull(node);
        queue.addAll(node.getChildren());
        return node;
    }
}
