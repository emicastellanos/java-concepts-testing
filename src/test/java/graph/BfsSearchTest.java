package graph;

import graph.helper.GraphFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BfsSearchTest {
    private Graph graph;
    private BfsSearch bfsToTest;

    @Before
    public void setUp() {
        graph = GraphFactory.createMockedGraph();
        bfsToTest = new BfsSearch();
    }

    @Test
    public void bfs() {
        Node node = graph.getNode(6).get();
        List<Integer> expected = Arrays.asList(6, 4, 7, 5, 8, 2, 1);
        List<Integer> result = bfsToTest.search(node);

        IntStream.range(0, expected.size())
                .forEach(i -> Assert.assertEquals(expected.get(i), (result.get(i))));
    }


}