package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/06/28
 * 89.房屋偷盗
 */
public class $89_rob {

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        // [i][0] = 第i间房子未盗窃
        // [i][1] = 第i间房子盗窃
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][1];
            //
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
