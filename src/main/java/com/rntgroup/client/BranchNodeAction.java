package com.rntgroup.client;

import com.rntgroup.graph.GraphNode;

public class BranchNodeAction implements NodeAction {

    @Override
    public void execute(GraphNode node) {
        System.out.println("I found branch: " + node);
    }
}
