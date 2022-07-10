package 面试;

public class 股票问题有冷冻期 {
    /**
     * @param prices daily price of the stock
     * @return maxProfit
     * 我们先考虑用户的状态。
     * 第一种状态:用户当天持有股票。
     * 第二种状态：用户当天不持有股票(并且处于冷却期中，代表用户今天卖掉了股票)
     * 第三种状态: 用户当天不持有股票，并且不处于冷却期中。
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[length - 1][1], dp[length - 1][2]);
    }
}
