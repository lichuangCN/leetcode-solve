package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/14
 * 123.买卖股票的最佳时间 仅交易2次
 */
public class $123_maxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length, max_k = 2;

        // [i][k][0/1] i天交易k次后 0不持有股票/1持有股票
        // k = 0:交易0次 1:交易1次 2:交易2次
        int[][][] dp = new int[len][max_k + 1][2];

        for (int i = 0; i < len; i++) {
            for (int k = 1; k <= max_k; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][max_k][0];
    }
}
