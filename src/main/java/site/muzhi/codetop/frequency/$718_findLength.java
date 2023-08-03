package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/03
 * 718.最长重复子数组
 */
public class $718_findLength {

    /**
     * 动态规划
     * 令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，那么答案即为所有 dp[i][j] 中的最大值。
     * 如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
     */
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int ans = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * 暴力解决
     */
    public int findLength_2(int[] nums1, int[] nums2) {

        // 暴力枚举
        int len1 = nums1.length, len2 = nums2.length;
        int ans = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // 每次都需要重置计算
                int idx_i = i, idx_j = j;
                while (idx_i < len1 && idx_j < len2 && nums1[idx_i] == nums2[idx_j]) {
                    idx_i++;
                    idx_j++;
                }
                ans = Math.max(ans, idx_j - j);
            }
        }
        return ans;
    }
}
