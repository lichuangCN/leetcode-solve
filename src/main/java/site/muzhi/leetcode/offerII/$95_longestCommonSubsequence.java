package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/07/03
 * 95.最长公共子序列
 */
public class $95_longestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int len1 = arr1.length, len2 = arr2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        // 还得是 m * n 的时间复杂度
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
