package site.muzhi.leetcode.dp;

/**
 * @author lichuang
 * @date 2021/04/24
 * @description 377. 组合总和 Ⅳ
 * <p>
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * <p>
 * https://leetcode-cn.com/problems/combination-sum-iv/solution/gong-shui-san-xie-yu-wan-quan-bei-bao-we-x0kn/
 * 定义 dp[i][j] 为组合长度为 i，凑成总和为 j 的方案数是多少。
 */
public class $377_combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        // nums中的元素最小为1，因此单个满足条件的集合的最大长度是target
        int len = target;
        int[][] dp = new int[len + 1][target + 1];
        dp[0][0] = 1;
        int res = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                for (int num : nums) {
                    if (j >= num) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
                res += dp[i][target];
            }
        }
        return res;
    }
}
