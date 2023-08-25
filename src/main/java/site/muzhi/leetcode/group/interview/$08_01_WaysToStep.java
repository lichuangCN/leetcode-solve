package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/03/24
 * @description 三步问题。
 * <p>
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模。
 */
public class $08_01_WaysToStep {

    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        int base = 1000000007;
        for (int i = 3; i < n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % base + dp[i - 3]) % base;
        }
        return dp[n - 1];
    }
}
