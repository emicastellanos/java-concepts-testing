package graph;

import java.util.LinkedList;
import java.util.List;

public class DfsSearch extends Search {

    @Override
    public List<Integer> search(Node node) {
        if (node == null) return null;
        List<Integer> result = new LinkedList<>();
        mark(node);
        visit(result, node);
        for (Node neighbour : node.getAdjacent()) {
            if (!isMarked(neighbour)) {
                result.addAll(search(neighbour));
            }
        }

        return result;
    }

}
