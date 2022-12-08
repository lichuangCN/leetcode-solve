package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/08
 * @description 198. 打家劫舍
 */
public class $198_rob {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            // 1.第i-1已经偷过，则dp[i]的值 = dp[i-1]
            // 2.第i-1没有偷过，则dp[i]的值 = dp[i-2] + nums[i]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
