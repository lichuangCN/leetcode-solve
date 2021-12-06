package site.muzhi.leetcode.dp;

/**
 * @author lichuang
 * @date 2021/04/24
 * @description 309. 最佳买卖股票时机含冷冻期
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * <p>
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class $309_maxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // [天][持股数目]
        int[][] dp = new int[len][2];
        // 第1天不持有股票的最大收益是0
        dp[0][0] = 0;
        // 第1天持有股票的最大收益是-price[0]
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 卖出股票后需要冷却1天后才能再次购买股票，即dp[i-2][0]
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
        }

        return dp[len - 1][0];
    }
}
