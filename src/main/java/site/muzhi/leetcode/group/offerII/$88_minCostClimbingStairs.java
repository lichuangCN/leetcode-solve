package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/06/28
 * 88.爬楼梯的最少成本
 */
public class $88_minCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        // 倒数第一层 或 倒数第二层
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
