package site.muzhi.codetop.bytedance;

/**
 * @author lichuang
 * @date 2022/11/18
 * 121. 买卖股票的最佳时机（只交易一次）
 */
public class $121_maxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // [i][0]:第i天 不持有股票的钱
        // [i][1]:第i天 持有股票的钱
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // 多次买卖
            //dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 仅限买卖一次
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
