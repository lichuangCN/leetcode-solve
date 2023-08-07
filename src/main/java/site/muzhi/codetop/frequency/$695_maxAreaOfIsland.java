package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/07
 * 695.岛屿的最大面积
 */
public class $695_maxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0, rows = grid.length, cols = grid[0].length;
        boolean[][] used = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ans = Math.max(ans, travel(grid, used, r, c));
            }
        }
        return ans;
    }

    private int travel(int[][] grid, boolean[][] used, int r, int c) {
        if (!inGrid(grid, r, c) || used[r][c] || grid[r][c] == 0) {
            return 0;
        }
        used[r][c] = true;
        int num = 1;
        num += travel(grid, used, r + 1, c);
        num += travel(grid, used, r, c + 1);
        num += travel(grid, used, r - 1, c);
        num += travel(grid, used, r, c - 1);
        return num;
    }

    private boolean inGrid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

}
