package site.muzhi.array;

/**
 * @author: lichuang
 * @date: 2020/03/09
 * @description: 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

public class $53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 记录整个过程中出现的最大值
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

}
