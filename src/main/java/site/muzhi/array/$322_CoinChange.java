package site.muzhi.array;

/**
 * @author: lichuang
 * @date: 2020/03/08
 * @description: 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */

public class $322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        // 初始化dp数组，赋值为amount+1
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = amount + 1;
        }

        for (int i = 0; i < dp.length; i++) {
            // 内部循环是处理子问题
            for (int coin : coins) {
                // 子问题无解
                if (i - coin < 0) {
                    // 因为coins数组不是有序数组，不能用break
                    continue;
                }
                // 将当前问题划分给子问题，从子问题中获得解
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        // 如果dp[amount]=amount+1，表明没有解
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
