package site.muzhi.dp;

/**
 * @author lichuang
 * @date 2021/04/15
 * @description 213. 打家劫舍 II
 * <p>
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class $213_rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 第一间必然不选
        int[] dp = new int[len];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int m = dp[len - 1];

        // 最后一间必然不选
        dp[0] = nums[0];
        dp[1] = nums[0];
        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int n = dp[len - 2];

        return Math.max(m, n);
    }

}
