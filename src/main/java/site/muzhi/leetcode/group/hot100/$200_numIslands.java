package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/13
 * 200.岛屿数量
 */
public class $200_numIslands {

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, ans = 0;
        boolean[][] used = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ans += travel(grid, used, r, c);
            }
        }
        return ans;
    }

    private int travel(char[][] grid, boolean[][] used, int r, int c) {
        if (!inGrid(grid, r, c) || used[r][c] || grid[r][c] == '0') {
            return 0;
        }
        used[r][c] = true;
        travel(grid, used, r + 1, c);
        travel(grid, used, r, c + 1);
        travel(grid, used, r - 1, c);
        travel(grid, used, r, c - 1);
        return 1;
    }

    private boolean inGrid(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
