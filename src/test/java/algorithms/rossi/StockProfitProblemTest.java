package algorithms.rossi;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StockProfitProblemTest {

    @Test
    public void getBestProfit() {
        StockProfitProblem stockProfitProblem = new StockProfitProblem();
        int[] arr = {90, 10, 20, 100};
        Integer expected = 90;
        Assert.assertEquals(expected, stockProfitProblem.getBestProfit(arr));

        int[] arr2 = {50, 200, 15, 30, 10, 40};
        Integer expected2 = 150;
        Assert.assertEquals(expected2, stockProfitProblem.getBestProfit(arr2));
    }
}