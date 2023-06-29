package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/06/29
 * 90.环形房屋偷盗
 */
public class $90_rob {

    public int rob(int[] nums) {
        // 分开计算
        int[][] dp = new int[nums.length][2];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 第一间必然不选
        dp[1][0] = 0;
        dp[1][1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
        }
        int max1 = Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);

        // 最后一间必然不选
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
        }
        int max2 = Math.max(dp[nums.length - 2][0], dp[nums.length - 2][1]);

        return Math.max(max1, max2);
    }
}
