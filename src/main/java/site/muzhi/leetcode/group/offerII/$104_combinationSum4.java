package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/07/06
 * 104.排列的数目
 */
public class $104_combinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];

        // [i]和为i时的排列组合的数目
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    // 汇总所有满足 [i-num]的解
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[len];
    }
}
