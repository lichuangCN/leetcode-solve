package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/07
 * 309.买卖股票的最佳时机（冷冻期）
 */
public class $309_maxProfit {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else if (i == 1) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[length - 1][0];
    }
}
