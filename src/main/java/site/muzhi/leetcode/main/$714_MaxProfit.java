package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/12/17
 * @description 买卖股票的最佳时机含手续费
 */
public class $714_MaxProfit {

    public int maxProfit(int[] prices, int fee) {
        // dp[i][0]表示第i天不持有股票
        // dp[i][1]表示第i天持有股票
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 单个状态转移数组
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit2(int[] prices, int fee) {
        // dp[0]表示第i天不持有股票
        // dp[1]表示第i天持有股票
        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int tem = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], tem - prices[i]);
        }
        return dp[0];
    }
}
