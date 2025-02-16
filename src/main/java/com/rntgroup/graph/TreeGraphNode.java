package com.rntgroup.graph;

import com.rntgroup.iteration.DFSIterationStrategy;
import com.rntgroup.iteration.IterationStrategy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class TreeGraphNode implements GraphNode {

    @ToString.Include
    private final int value;
    @Getter
    private final List<GraphNode> children = new ArrayList<>();
    @Setter
    private IterationStrategy iterationStrategy = new DFSIterationStrategy(); // По умолчанию будет DFS итератор

    @Override
    public void addChild(GraphNode child) {
        Objects.requireNonNull(child);
        children.add(child);
    }

    @Override
    public void print() {
        System.out.println((isLeaf() ? "leaf" : "branch") + " value: " + value);
    }

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public Iterator<GraphNode> iterator() {
        return iterationStrategy.createIterator(this);
    }
}

