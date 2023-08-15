package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/15
 * 198.打家劫舍
 */
public class $198_rob {

    public int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][2];
        // base 第一间屋子处理
        dp[1][0] = 0;
        dp[1][1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i - 1], dp[i - 2][1] + nums[i - 1]);
        }
        return Math.max(dp[len][0], dp[len][1]);
    }

}
