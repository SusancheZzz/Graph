package com.rntgroup.graph;

import com.rntgroup.iteration.IterationStrategy;

import java.util.List;

public interface GraphNode extends Iterable<GraphNode> {

    void addChild(GraphNode child);
    void print();
    List<GraphNode> getChildren();
    boolean isLeaf();
    void setIterationStrategy(IterationStrategy strategy);
}
