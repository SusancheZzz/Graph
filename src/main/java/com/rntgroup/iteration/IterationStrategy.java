package com.rntgroup.iteration;

import com.rntgroup.graph.GraphNode;

import java.util.Iterator;

public interface IterationStrategy {
    Iterator<GraphNode> createIterator(GraphNode root);
}
