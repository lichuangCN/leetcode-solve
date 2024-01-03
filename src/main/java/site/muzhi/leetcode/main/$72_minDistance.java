package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/03
 * 72.编辑距离
 */
public class $72_minDistance {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int l1 = 1; l1 <= len1; l1++) {
            for (int l2 = 1; l2 <= len2; l2++) {
                if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) {
                    dp[l1][l2] = dp[l1 - 1][l2 - 1];
                } else {
                    // 插入、删除、修改
                    dp[l1][l2] = Math.min(dp[l1 - 1][l2 - 1], Math.min(dp[l1 - 1][l2], dp[l1][l2 - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
