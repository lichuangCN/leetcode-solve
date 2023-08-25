package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/03/17
 * @description
 */
public class $115_NumDistinct {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        s = " " + s;
        t = " " + t;
        int[][] dp = new int[m + 1][n + 1];
        char[] cs = s.toCharArray(), ct = t.toCharArray();

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];

                if (cs[i] == ct[j]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
