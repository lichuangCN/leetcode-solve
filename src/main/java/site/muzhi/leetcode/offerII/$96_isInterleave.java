package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/07/05
 * 96.字符串交织
 */
public class $96_isInterleave {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len3 != len1 + len2) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int idx = i + j - 1;
                // dp[i][j] --> dp[i-1][j] || dp[i][j-1]
                boolean oki = false, okj = false;
                if (i > 0) {
                    oki = dp[i - 1][j] && s3.charAt(idx) == s1.charAt(i - 1);
                    dp[i][j] = oki;
                }
                if (j > 0) {
                    okj = dp[i][j - 1] && s3.charAt(idx) == s2.charAt(j - 1);
                    // i 或 j满足其中一个条件
                    dp[i][j] = oki || okj;
                }
            }
        }
        return dp[len1][len2];
    }
}
