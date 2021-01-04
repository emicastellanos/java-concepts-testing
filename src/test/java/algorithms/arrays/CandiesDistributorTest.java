package algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandiesDistributorTest {

    @Test
    public void getMaxNumberOfDiffTypesOfCandiesWhenCandiesInputIsEmpty() {
        CandiesDistributor candiesDistributor = new CandiesDistributor();
        int[] candyTypes = new int[0];
        int expected = 0;
        Assert.assertEquals(expected, candiesDistributor.getMaxNumberOfDiffTypesOfCandies(candyTypes, 0));
    }

    @Test
    public void getMaxNumberOfDiffTypesOfCandiesNormalCase() {
        CandiesDistributor candiesDistributor = new CandiesDistributor();
        int[] candyTypes = {1, 1, 2, 2, 3, 3};
        int allowed = candyTypes.length / 2;
        int expected = 3;
        Assert.assertEquals(expected, candiesDistributor.getMaxNumberOfDiffTypesOfCandies(candyTypes, allowed));

        int[] candyTypeSecondExample = {1, 1, 2, 3};
        allowed = candyTypeSecondExample.length / 2;
        expected = 2;
        Assert.assertEquals(expected, candiesDistributor.getMaxNumberOfDiffTypesOfCandies(candyTypeSecondExample, allowed));

        int[] candyTypeThirdExample = {6, 6, 6, 6};
        allowed = candyTypeThirdExample.length / 2;
        expected = 1;
        Assert.assertEquals(expected, candiesDistributor.getMaxNumberOfDiffTypesOfCandies(candyTypeThirdExample, allowed));
    }
}