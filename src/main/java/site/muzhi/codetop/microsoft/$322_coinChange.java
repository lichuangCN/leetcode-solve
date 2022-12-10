package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/09
 * @description 322. 零钱兑换
 */
public class $322_coinChange {

    public int coinChange(int[] coins, int amount) {

        // dp[i]: 凑够总金额 = i时需要的金币数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                // i-coin: 剩余总金额
                // dp[i-coin]：向下寻找
                if (i - coin >= 0 && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
