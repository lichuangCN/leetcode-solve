package site.muzhi.array;

/**
 * @author: lichuang
 * @date: 2020/03/09
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */

public class $70_ClimbStairs {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 登上当前台阶的方法种数应该是上一个台阶通过跨过两个台阶的方法
            // 加上跨过一个台阶的方法和
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
