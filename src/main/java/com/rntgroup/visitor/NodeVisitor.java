package com.rntgroup.visitor;

import com.rntgroup.client.NodeAction;
import com.rntgroup.graph.GraphNode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NodeVisitor implements Visitor {

    private final NodeAction leafAction;
    private final NodeAction branchAction;

    @Override
    public void visit(GraphNode node) {
        if (node.getChildren().isEmpty()) {
            leafAction.execute(node);
        } else {
            branchAction.execute(node);
        }
    }
}
