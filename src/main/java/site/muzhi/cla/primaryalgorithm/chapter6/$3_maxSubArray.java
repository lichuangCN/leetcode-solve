package site.muzhi.cla.primaryalgorithm.chapter6;

/**
 * @author lichuang
 * @date 2021/05/21
 * @description 最大子序和
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn3cg3/
 */
public class $3_maxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = (dp[i] > max) ? dp[i] : max;
        }
        return max;
    }
}
