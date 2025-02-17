package com.rntgroup.traversal;

import com.rntgroup.graph.GraphNode;
import com.rntgroup.visitor.Visitor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@AllArgsConstructor
public class GraphTraversal {

    private TraversalStrategy strategy;

    public void traverse(GraphNode root, Visitor visitor) {
        Objects.requireNonNull(root);
        Objects.requireNonNull(visitor);
        strategy.traverse(root, visitor);
    }
}
