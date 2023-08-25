package site.muzhi.leetcode.clazz.primaryalgorithm.chapter1;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 买卖股票的最佳时机 II
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 */
public class $2_maxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
