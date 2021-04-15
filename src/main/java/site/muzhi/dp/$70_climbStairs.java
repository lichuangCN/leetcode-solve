package site.muzhi.dp;

/**
 * @author lichuang
 * @date 2021/04/15
 * @description 70. 爬楼梯
 * <p>
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class $70_climbStairs {

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
