package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/04/24
 * @description 123. 买卖股票的最佳时机 III（只能进行指定交易次数，本题中指定2次）
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * <p>
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class $123_maxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // [天][交易次数][持股数目]
        int[][][] dp = new int[len][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 交易1次，并且不持有股票
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            // 交易1次，并且持有股票，即第一次购买股票,下面两个等式等效
            //dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i-1][0][0]-prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            // 交易2次，并且不持有股票
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            // 交易2次，并且持有股票，即第二次购买股票
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
        }
        return dp[len - 1][2][0];
    }

}
