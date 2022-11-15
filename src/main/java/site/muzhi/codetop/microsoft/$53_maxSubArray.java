package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/15
 * 53 最大子数组和
 * 思想：动态规划
 */
public class $53_maxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
