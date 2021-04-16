package algorithms.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DistributeCandyProblemTest {

    @Test
    public void getMinimumCandies_1() {
        int[] a = {1, 3, 3};
        int[] expected = {1, 2, 1};
        int[] result = DistributeCandyProblem.getMinimumCandies(a);

        assert Arrays.equals(expected, result);

    }

    @Test
    public void getMinimumCandies_2() {
        int[] a = {1, 3, 4};
        int[] expected = {1, 2, 3};
        int[] result = DistributeCandyProblem.getMinimumCandies(a);

        assert Arrays.equals(expected, result);
    }

    @Test
    public void getMinimumCandies_3() {
        int[] a = {1, 5, 2, 1, 4, 1};
        int[] expected = {1, 3, 2, 1, 2, 1};
        int[] result = DistributeCandyProblem.getMinimumCandies(a);

        assert Arrays.equals(expected, result);
    }

    @Test
    public void getMinimumCandies_4() {
        int[] a = {5, 2, 4, 1, 3, 3, 1, 6};
        int[] expected = {3, 2, 3, 1, 2, 2, 1, 2};
        int[] result = DistributeCandyProblem.getMinimumCandies(a);

        assert Arrays.equals(expected, result);
    }

    @Test
    public void getMinimumCandies_5() {
        int[] a = {5, 4, 3, 2, 1};
        int[] expected = {5, 4, 3, 2, 1};
        int[] result = DistributeCandyProblem.getMinimumCandies(a);

        assert Arrays.equals(expected, result);
    }

    @Test
    public void getMinimumCandies_6() {
        int[] a = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = DistributeCandyProblem.getMinimumCandies(a);

        assert Arrays.equals(expected, result);
    }
}