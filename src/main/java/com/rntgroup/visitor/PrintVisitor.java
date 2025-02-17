package com.rntgroup.visitor;

import com.rntgroup.graph.GraphNode;

public class PrintVisitor implements Visitor {

    @Override
    public void visit(GraphNode node) {
        node.print();
    }
}
