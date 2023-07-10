package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/07/10
 * 105.岛屿的最大面积
 */
public class $105_maxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, travel(grid, used, r, c));
            }
        }
        return ans;
    }

    private int travel(int[][] grid, boolean[][] used, int r, int c) {
        if (!inGrid(r, c, grid) || used[r][c] || grid[r][c] == 0) {
            return 0;
        }
        // 上右下左
        used[r][c] = true;
        int count = 1;
        count += travel(grid, used, r + 1, c);
        count += travel(grid, used, r, c + 1);
        count += travel(grid, used, r - 1, c);
        count += travel(grid, used, r, c - 1);
        return count;
    }

    private boolean inGrid(int r, int c, int[][] grid) {
        int row = grid.length, col = grid[0].length;
        return r >= 0 && r < row && c >= 0 && c < col;
    }

}
