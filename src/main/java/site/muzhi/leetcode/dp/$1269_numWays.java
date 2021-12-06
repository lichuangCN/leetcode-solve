package site.muzhi.leetcode.dp;

/**
 * @author lichuang
 * @date 2021/05/13
 * @description 1269. 停在原地的方案数
 * <p>
 * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 */
public class $1269_numWays {

    public int numWays(int steps, int arrLen) {

        // 最远到达的位置是 steps/2，max即跳跃维度的范围
        int max = Math.min(steps / 2, arrLen - 1);

        int mod = (int) 1e9 + 7;
        // [i][j] i: 剩余操作数,j:所在位置
        // dp[i][j] 在剩余操作数为i，并且所在位置为j的所有方案数
        int[][] dp = new int[steps + 1][max + 1];
        dp[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            for (int j = 0; j <= max; j++) {
                // 原地不动
                dp[i][j] = (dp[i][j] + dp[i + 1][j]) % mod;
                // 向左
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % mod;
                }
                // 向右
                if (j + 1 <= max) {
                    dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % mod;
                }
            }
        }
        return dp[0][0];
    }
}
