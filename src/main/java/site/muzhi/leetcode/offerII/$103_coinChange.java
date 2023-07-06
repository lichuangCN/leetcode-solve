package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/07/06
 * 103.最少的硬币数目
 */
public class $103_coinChange {

    public static void main(String[] args) {
        $103_coinChange demo = new $103_coinChange();
        System.out.println(demo.coinChange(new int[]{2}, 3));
    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        // 满足 [i(account)] 时的最少硬币数
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 记录凑够价值=i时所需要的最小硬币数
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                // dp[i-coin] < min 存在凑够 i-coin时更少的硬币数
                if (i >= coin && dp[i - coin] < min) {
                    // 比较最小硬币数
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
