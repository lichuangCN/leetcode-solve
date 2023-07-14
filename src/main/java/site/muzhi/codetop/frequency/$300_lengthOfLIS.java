package site.muzhi.codetop.frequency;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/07/14
 * 30.最长递增子序列
 */
public class $300_lengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        // 默认每个位置的最长子序列的最小值一定是1
        Arrays.fill(dp, 1);

        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
