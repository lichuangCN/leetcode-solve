package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/07
 * 121.买卖股票的最佳时机
 */
public class $121_maxProfit {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }
        return dp[prices.length - 1][0];
    }
}
