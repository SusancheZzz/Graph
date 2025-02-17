package com.rntgroup.client;

import com.rntgroup.graph.GraphNode;
import com.rntgroup.traversal.GraphTraversal;
import com.rntgroup.visitor.NodeVisitor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GraphClient {

    private final GraphTraversal traversal;
    private final NodeVisitor visitor = new NodeVisitor(new LeafNodeAction(), new BranchNodeAction());

    public void processGraph(GraphNode root) {
        traversal.traverse(root, visitor);
    }
}
