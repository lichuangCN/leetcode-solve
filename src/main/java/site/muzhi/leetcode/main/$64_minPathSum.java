package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/03
 * 64.最小路径和
 */
public class $64_minPathSum {

    public static void main(String[] args) {
        $64_minPathSum demo = new $64_minPathSum();
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        demo.minPathSum(nums);
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        //
        for (int i = 0; i < rows; i++) {
            dp[i][0] = (i > 0 ? dp[i - 1][0] : 0) + grid[i][0];
        }
        for (int i = 0; i < cols; i++) {
            dp[0][i] = (i > 0 ? dp[0][i - 1] : 0) + grid[0][i];
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
