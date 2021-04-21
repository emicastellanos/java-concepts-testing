package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int value;
    private List<Node> adjacent;


    public Node(int value) {
        this.value = value;
        adjacent = new ArrayList<>();
    }

    public void addAdjacent(Node n) {
        adjacent.add(n);
    }

    public List<Node> getAdjacent() {
        return adjacent;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" +
                "value = " + value +
                '}';
    }
}
