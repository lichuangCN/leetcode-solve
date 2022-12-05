package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/05
 * @description 64. 最小路径和
 */
public class $64_minPathSum {

    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        // 初始化边界值
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                // 上面的值+当前值 左面的值+当前值
                dp[r][c] = Math.min(dp[r - 1][c] + grid[r][c], dp[r][c - 1] + grid[r][c]);
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
