package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/12
 * 198.打家劫舍
 */
public class $198_rob {

    public int rob(int[] nums) {

        int len = nums.length;
        int[][] dp = new int[len][2];
        // base 第一间屋子处理
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 第2间屋子偷窃时处理
            if (i == 1) {
                dp[i][1] = nums[i];
            } else {
                dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 2][1] + nums[i]);
            }
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
