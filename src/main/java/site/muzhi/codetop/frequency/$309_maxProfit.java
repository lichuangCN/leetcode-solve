package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/14
 * 309.买卖股票的最佳时机 冷冻期
 */
public class $309_maxProfit {

    public int maxProfit(int[] prices) {
        // base
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 第二天的数据依赖于第一天
        dp[1][0] = Math.max(dp[0][0], dp[0][0] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天购入，则应该从第i-2天开始计算
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
