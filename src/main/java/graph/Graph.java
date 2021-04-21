package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Graph {
    private List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Optional<Node> getNode(int value) {
        return nodes.parallelStream()
                .filter(node -> node.getValue() == value)
                .findAny();
    }

    public List<Node> getNodes() {
        return nodes;
    }

}
