package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/31
 * 53.最大子数组和
 */
public class $53_maxSubArray {

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // dp[i] 表示 以nums[i]为结尾的子数组（该数组包含nums[i]）的最大值
            // dp[i-1]>0    dp[i] = dp[i-1]+nums[i]
            // dp[i-1]<=0   dp[i] = nums[i]
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
