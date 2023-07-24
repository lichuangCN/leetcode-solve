package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/24
 * 322.零钱兑换
 */
public class $322_coinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            // 初始值
            dp[i] = Integer.MAX_VALUE;
            // 整个for循环都是在定位dp[i]的最小值
            for (int coin : coins) {
                // 凑齐 i-coin 比 i 所需要的钱币少
                if (i >= coin && dp[i - coin] < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
