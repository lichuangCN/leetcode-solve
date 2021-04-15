package site.muzhi.dp;

/**
 * @author lichuang
 * @date 2021/04/15
 * @description 198. 打家劫舍
 * <p>
 * https://leetcode-cn.com/problems/house-robber/
 */
public class $198_rob {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
