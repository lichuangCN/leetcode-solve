package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/07
 * 70.爬楼梯
 */
public class $70_climbStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
