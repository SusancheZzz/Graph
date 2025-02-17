package com.rntgroup.iteration;

import com.rntgroup.graph.GraphNode;

import java.util.Iterator;
import java.util.Objects;

public class BFSIterationStrategy implements IterationStrategy {

    @Override
    public Iterator<GraphNode> createIterator(GraphNode root) {
        Objects.requireNonNull(root);
        return new BFSIterator(root);
    }
}
