package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/12
 * 200.岛屿数量
 */
public class $200_numIslands {

    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] used = new boolean[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans += travel(grid, used, i, j);
            }
        }
        return ans;
    }

    private int travel(char[][] grid, boolean[][] used, int r, int c) {
        if (!inGrid(grid, r, c) || grid[r][c] == '0' || used[r][c] == true) {
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
        int row = grid.length, col = grid[0].length;
        return r >= 0 && r < row && c >= 0 && c < col;
    }
}
