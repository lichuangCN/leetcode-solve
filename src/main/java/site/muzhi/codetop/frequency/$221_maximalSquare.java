package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/01
 * 221.最大正方形
 */
public class $221_maximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length, maxLen = 0;
        int[][] dp = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '1') {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = Math.min(Math.min(dp[r][c - 1], dp[r - 1][c]), dp[r - 1][c - 1]) + 1;
                    }
                }
                maxLen = Math.max(maxLen, dp[r][c]);
            }
        }
        return maxLen * maxLen;
    }
}
