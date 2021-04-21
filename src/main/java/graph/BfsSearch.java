package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsSearch extends Search {

    @Override
    public List<Integer> search(Node node) {
        if (node == null) return null;
        List<Integer> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        mark(node);
        while (!queue.isEmpty()) {
            Node r = queue.poll();
            visit(result, r);
            for (Node neighbour : r.getAdjacent()) {
                if (!isMarked(neighbour)) {
                    mark(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return result;
    }
}
