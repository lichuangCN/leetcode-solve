package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/14
 * 188.买卖股票的最佳时机 仅限交易k次
 */
public class $188_maxProfit {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length, max_k = k;

        int[][][] dp = new int[len][max_k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int mk = 1; mk <= max_k; mk++) {
                if (i == 0) {
                    dp[i][mk][0] = 0;
                    dp[i][mk][1] = -prices[i];
                    continue;
                }

                dp[i][mk][0] = Math.max(dp[i - 1][mk][0], dp[i - 1][mk][1] + prices[i]);
                dp[i][mk][1] = Math.max(dp[i - 1][mk][1], dp[i - 1][mk - 1][0] - prices[i]);
            }
        }

        return dp[len - 1][max_k][0];
    }
}
