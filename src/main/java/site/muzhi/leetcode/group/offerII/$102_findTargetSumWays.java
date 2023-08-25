package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/07/06
 * 102.加减的目标值 （背包问题）
 */
public class $102_findTargetSumWays {

    /**
     * 动态规划 转化为背包问题
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int len = nums.length, neg = diff / 2;
        // 背包问题
        int[][] dp = new int[len + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                // 如果 j<num，则不能选 num，此时有 dp[i][j]=dp[i−1][j]；
                // 如果 j≥num，则如果不选 num，方案数是 dp[i−1][j]，如果选 num，方案数是 dp[i−1][j−num]，此时有 dp[i][j]=dp[i−1][j]+dp[i−1][j−num]。
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][neg];
    }

    /**
     * 递归 遍历+回溯 出所有解
     */
    public int findTargetSumWays_2(int[] nums, int target) {
        return travel(nums, 0, target, 0);
    }

    private int travel(int[] nums, int currSum, int target, int idx) {
        if (idx == nums.length) {
            // currSum == target 寻找到一个解
            return currSum == target ? 1 : 0;
        }
        // +第idx元素
        int add = travel(nums, currSum + nums[idx], target, idx + 1);
        // -第idx元素
        int sub = travel(nums, currSum - nums[idx], target, idx + 1);
        return add + sub;
    }
}
