package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/30
 * 70.爬楼梯
 */
public class $70_climbStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
