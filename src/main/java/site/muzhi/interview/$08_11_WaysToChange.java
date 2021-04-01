package site.muzhi.interview;

/**
 * @author lichuang
 * @date 2021/04/01
 * @description 面试题 08.11. 硬币
 * <p>
 * https://leetcode-cn.com/problems/coin-lcci/
 */
public class $08_11_WaysToChange {

    /**
     * 二维数组
     *
     * @param n
     * @return
     */
    public int waysToChange(int n) {

        int base = 1000000007;
        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[5][n + 1];
        for (int i = 1; i <= 4; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j] % base;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i - 1]]) % base;
                }
            }
        }
        return dp[4][n];
    }

}
