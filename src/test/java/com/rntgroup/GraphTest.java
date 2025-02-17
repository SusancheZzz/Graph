package com.rntgroup;

import com.rntgroup.client.GraphClient;
import com.rntgroup.graph.GraphNode;
import com.rntgroup.graph.TreeGraphNode;
import com.rntgroup.iteration.BFSIterationStrategy;
import com.rntgroup.traversal.BFSTraversalStrategy;
import com.rntgroup.traversal.DFSTraversalStrategy;
import com.rntgroup.traversal.GraphTraversal;
import com.rntgroup.visitor.PrintVisitor;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GraphTest {

    public static Stream<Arguments> getGraph(){

        GraphNode root = new TreeGraphNode(5);
        GraphNode child1 = new TreeGraphNode(2);
        GraphNode child2 = new TreeGraphNode(5);
        GraphNode child3 = new TreeGraphNode(3);
        GraphNode child4 = new TreeGraphNode(2);
        GraphNode child5 = new TreeGraphNode(7);

        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(child5);
        child2.addChild(child3);
        child2.addChild(child4);

        return Stream.of(Arguments.of(root));
    }

    public static Stream<Arguments> getTraversalStrategies() {
        return getGraph().flatMap(root -> Stream.of(
            Arguments.of(root.get()[0], new GraphTraversal(new DFSTraversalStrategy())),
            Arguments.of(root.get()[0], new GraphTraversal(new BFSTraversalStrategy()))
        ));
    }

    @ParameterizedTest
    @MethodSource("getTraversalStrategies")
    public void testTraversal(GraphNode root, GraphTraversal traversal) {
        assertDoesNotThrow(() -> traversal.traverse(root, new PrintVisitor()));
    }

    @ParameterizedTest
    @MethodSource("getGraph")
    public void testForEachIteration(GraphNode root) {
        assertDoesNotThrow(() -> {
            for (GraphNode node : root) {
                node.print();
            }
        });
    }

    @ParameterizedTest
    @MethodSource("getGraph")
    public void testIterationStrategyChange(GraphNode root) {
        root.setIterationStrategy(new BFSIterationStrategy());
        assertDoesNotThrow(() -> {
            for (GraphNode node : root) {
                node.print();
            }
        });
    }

    @ParameterizedTest
    @MethodSource("getTraversalStrategies")
    public void testGraphClient(GraphNode root, GraphTraversal traversal) {
        GraphClient client = new GraphClient(traversal);
        assertDoesNotThrow(() -> client.processGraph(root));
    }

}
