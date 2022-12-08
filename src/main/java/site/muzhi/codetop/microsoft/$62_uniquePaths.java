package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/08
 * @description 62. 不同路径
 */
public class $62_uniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化边界值
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
