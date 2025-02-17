package com.rntgroup.traversal;

import com.rntgroup.graph.GraphNode;
import com.rntgroup.visitor.Visitor;

public interface TraversalStrategy {

    void traverse(GraphNode root, Visitor visitor);
}
