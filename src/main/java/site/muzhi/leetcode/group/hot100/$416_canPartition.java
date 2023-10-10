package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/10
 * 416.分割等和子集 (背包问题)
 */
public class $416_canPartition {

    public boolean canPartition(int[] nums) {
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int half = sum / 2;
        if (max > half) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length][half + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 1; j <= half; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }
        return dp[nums.length - 1][half];
    }
}
