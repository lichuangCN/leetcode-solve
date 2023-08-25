package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/25
 * 53.最大子数组和
 */
public class $53_maxSubArray {

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
                ans = dp[i];
            } else {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
