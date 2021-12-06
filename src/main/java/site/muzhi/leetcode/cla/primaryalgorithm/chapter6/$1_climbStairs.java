package site.muzhi.leetcode.cla.primaryalgorithm.chapter6;

/**
 * @author lichuang
 * @date 2021/05/21
 * @description 爬楼梯
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn854d/
 */
public class $1_climbStairs {

    public int climbStairs(int n) {
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
