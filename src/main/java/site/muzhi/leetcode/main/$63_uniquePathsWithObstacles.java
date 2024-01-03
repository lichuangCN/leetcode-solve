package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/02
 * 63.不同路径 II
 */
public class $63_uniquePathsWithObstacles {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < cols && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (obstacleGrid[r][c] == 0) {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

}
