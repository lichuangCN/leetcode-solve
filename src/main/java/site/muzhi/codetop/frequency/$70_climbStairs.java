package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/20
 * 70.爬楼梯
 */
public class $70_climbStairs {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
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
