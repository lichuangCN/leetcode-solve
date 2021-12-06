package site.muzhi.leetcode.dp;

/**
 * @author lichuang
 * @date 2021/04/03
 * @description 1143. 最长公共子序列
 * <p>
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class $1143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        char[] arr1 = text1.toCharArray(), arr2 = text2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
