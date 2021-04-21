package graph.helper;

import graph.Graph;
import graph.Node;

public class GraphFactory {

    public static Graph createMockedGraph() {
        Graph graph = new Graph();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n2.addAdjacent(n1);
        n2.addAdjacent(n4);
        n2.addAdjacent(n5);

        n4.addAdjacent(n5);

        n5.addAdjacent(n2);
        n5.addAdjacent(n6);

        n6.addAdjacent(n4);
        n6.addAdjacent(n7);

        n7.addAdjacent(n8);

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);
        graph.addNode(n6);
        graph.addNode(n7);
        graph.addNode(n8);

        return graph;
    }
}
