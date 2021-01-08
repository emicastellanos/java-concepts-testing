package algorithms.rossi;

/**
 * Given a list of historic stock prices, write a function that tells when you should have
 * bought and sold to make the most profit and how much is the profit. You can only buy and sell once
 * <p>
 * (90, 200, 10, 20, 100) = 90
 * (50, 200, 15, 30, 10, 40) = 150
 */
public class StockProfitProblem {
    private static final Integer NON_VALID_PROFIT = -1;

    public Integer getBestProfit(int[] arr) {
        if (arr.length == 0) return NON_VALID_PROFIT;

        Integer profit = 0;
        Integer minimum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < minimum){
                minimum = arr[i];
            }
            if( profit < arr[i] - minimum){
                profit = arr[i] - minimum;
            }
        }

        return profit;
    }
}
