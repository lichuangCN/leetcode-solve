package site.muzhi.codetop.frequency;

/**
 * @auth lichuang
 * @data 2023/07/31
 * 64.最小路径和
 */
public class $64_minPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        // 初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int c = 1; c < grid[0].length; c++) {
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        }

        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[0].length; c++) {
                dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
            }
        }
        return dp[row - 1][col - 1];

    }
}
