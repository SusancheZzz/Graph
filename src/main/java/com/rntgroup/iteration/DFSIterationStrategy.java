package com.rntgroup.iteration;

import com.rntgroup.graph.GraphNode;

import java.util.Iterator;
import java.util.Objects;

public class DFSIterationStrategy implements IterationStrategy {

    @Override
    public Iterator<GraphNode> createIterator(GraphNode root) {
        Objects.requireNonNull(root);
        return new DFSIterator(root);
    }
}
