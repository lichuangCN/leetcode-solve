package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/25
 * @description
 */
public class $121_maxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // [i][0] : 未持有股票
        // [i][1] : 持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
        }
        return dp[prices.length - 1][0];
    }
}
