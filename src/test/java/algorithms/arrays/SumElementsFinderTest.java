package algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class SumElementsFinderTest {

    @Test
    public void getElementsRegularFlow() {
        SumElementsFinder sumElementsFinder = new SumElementsFinder();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Pair pairExpected = new Pair(0, 1);
        Optional<Pair> result = sumElementsFinder.getElements(nums, target);

        Assert.assertEquals(pairExpected, result.get());

    }

    @Test
    public void getElementsWhenInputIsEmpty() {
        SumElementsFinder sumElementsFinder = new SumElementsFinder();
        int[] nums = {};
        int target = 8;

        Assert.assertEquals(Optional.empty(), sumElementsFinder.getElements(nums, target));
    }

    @Test
    public void getElementsWhenNotSolutionIsFound() {
        SumElementsFinder sumElementsFinder = new SumElementsFinder();
        int[] nums = {1, 4, 5, 6};
        int target = 8;

        Assert.assertEquals(Optional.empty(), sumElementsFinder.getElements(nums, target));
        int[] oneElement = {1};

        Assert.assertEquals(Optional.empty(), sumElementsFinder.getElements(oneElement, target));
    }
}