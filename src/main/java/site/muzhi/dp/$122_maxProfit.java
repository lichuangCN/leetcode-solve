package site.muzhi.dp;

/**
 * @author lichuang
 * @date 2021/04/24
 * @description 122. 买卖股票的最佳时机 II（多次交易）
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class $122_maxProfit {
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
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
