package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/14
 * 221.最大正方形
 */
public class $221_maximalSquare {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, max = 0;
        int[][] dp = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '1') {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = Math.min(Math.min(dp[r - 1][c - 1], dp[r - 1][c]), dp[r][c - 1]) + 1;
                    }
                    max = Math.max(max, dp[r][c]);
                }
            }
        }
        return max * max;
    }
}
