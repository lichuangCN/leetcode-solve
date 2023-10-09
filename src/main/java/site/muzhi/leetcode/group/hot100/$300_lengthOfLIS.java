package site.muzhi.leetcode.group.hot100;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/10/07
 * 300.最长递增子序列
 */
public class $300_lengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int ans = 1;
        for (int i = 1; i < len; i++) {
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
