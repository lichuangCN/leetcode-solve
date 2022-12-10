package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/10
 * @description 300. 最长递增子序列
 */
public class $300_lengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            // 初始化 默认长度 = 1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                //
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
