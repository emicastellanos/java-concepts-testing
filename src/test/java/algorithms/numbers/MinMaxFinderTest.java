package algorithms.numbers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinMaxFinderTest {
    private MinMaxFinder minMaxFinder;

    @Before
    public void init() {
        minMaxFinder = new MinMaxFinder();
    }

    @Test
    public void getMinAndMaxWhenNoValuesShouldReturnNull() {
        Assert.assertNull(minMaxFinder.getMinAndMax(null));
    }

    @Test
    public void getMinAndMaxWhenOneElementShouldReturnThatAsMinAndMax() {
        int[] input = { 2 };
        MinMaxFinder.MinMax minMax = minMaxFinder.getMinAndMax(input);
        Assert.assertEquals(2, minMax.getMin());
        Assert.assertEquals(2, minMax.getMax());
    }

    @Test
    public void getMinAndMaxWhenOddAmountOfElements(){
        int[] input = { 0, 3, -1, 5, -4};
        MinMaxFinder.MinMax minMax = minMaxFinder.getMinAndMax(input);
        Assert.assertEquals(-4, minMax.getMin());
        Assert.assertEquals(5, minMax.getMax());
    }

    @Test
    public void getMinAndMaxWhenEvenAmountOfElements(){
        int[] input = { 0, 3, -1, 5, -4, 10};
        MinMaxFinder.MinMax minMax = minMaxFinder.getMinAndMax(input);
        Assert.assertEquals(-4, minMax.getMin());
        Assert.assertEquals(10, minMax.getMax());
    }
}