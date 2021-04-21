package graph;

import java.util.LinkedList;
import java.util.List;

public abstract class Search {
    private LinkedList<Node> marks = new LinkedList<>();

    public abstract List<Integer> search(Node node);

    protected void visit(List<Integer> visited, Node n) {
        visited.add(n.getValue());
    }

    protected void mark(Node node) {
        marks.add(node);
    }

    protected boolean isMarked(Node node) {
        return marks.stream()
                .filter(n -> node.getValue() == (n.getValue()))
                .findAny()
                .isPresent();
    }
}
