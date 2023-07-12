package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/12
 * 121.买卖股票的最佳时机
 */
public class $121_maxProfit {
    // 输入：[7,1,5,3,6,4]
    // 输出：5
    public int maxProfit(int[] prices) {
        // [i][0] 第i天不持有股票的最大收益
        // [i][1] 第i天持有股票的最大收益
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0], -prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
