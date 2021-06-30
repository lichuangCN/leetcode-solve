package site.muzhi.dp;

/**
 * @author lichuang
 * @date 2021/04/24
 * @description 188. 买卖股票的最佳时机 IV（指定交易次数，并且同时只能持有一张股票）
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * <p>
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class $188_maxProfit {

    public int maxProfit(int k, int[] prices) {
        if (k < 0 || prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // [天][交易次数][持股数目]
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 第j次交易，并且持有股票，（①第j次交易已经持有股票；②第j-1次交易后不持有股票，在第j次交易购买股票）
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[len - 1][k][0];
    }
}
