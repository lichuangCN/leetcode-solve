package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/07/05
 * 101.分割等和子集
 */
public class $101_canPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0, target = 0, max = 0, len = nums.length;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        // 奇数
        if (sum % 2 != 0) {
            return false;
        }
        target = sum / 2;

        // 如果符合要求 平分值 <= 最大值 是必要条件
        if (target < max) {
            return false;
        }

        // dp[i][j] : 在[0,i]范围内，存在解：选取若干个值，使得它们的和 = j
        boolean[][] dp = new boolean[len][target + 1];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < len; i++) {
            int n = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= n) {
                    // 选取 nums[i] (dp[i-1][j-nums[i]]) 或者不选取 nums[i] (dp[i-1][j])
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    // 无法选取nums[i]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }
}
