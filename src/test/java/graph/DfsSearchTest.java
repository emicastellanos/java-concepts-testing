package graph;

import graph.helper.GraphFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class DfsSearchTest {
    private Graph graph;
    private DfsSearch dfsSearch;

    @Before
    public void init() {
        graph = GraphFactory.createMockedGraph();
        dfsSearch = new DfsSearch();
    }

    @Test
    public void search() {
        Node node = graph.getNode(2).get();

        List<Integer> expected = Arrays.asList(2, 1, 4, 5, 6, 7, 8);
        List<Integer> result = dfsSearch.search(node);
        IntStream.range(0, expected.size())
                .forEach(i -> Assert.assertEquals(expected.get(i), (result.get(i))));

    }
}