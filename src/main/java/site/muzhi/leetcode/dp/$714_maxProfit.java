package site.muzhi.leetcode.dp;

/**
 * @author lichuang
 * @date 2021/04/24
 * @description 714. 买卖股票的最佳时机含手续费
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * <p>
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class $714_maxProfit {

    public int maxProfit(int[] prices, int fee) {
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
            // 在卖出股票的时候扣除手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
