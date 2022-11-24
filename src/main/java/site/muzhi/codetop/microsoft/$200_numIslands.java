package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/24
 * @description 200. 岛屿数量
 */
public class $200_numIslands {


    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    find(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    private void find(char[][] grid, int r, int c) {
        if (!inGrid(grid, r, c)) {
            return;
        }
        // 已经遍历过
        if (grid[r][c] == '2') {
            return;
        }
        // 标记为遍历过
        grid[r][c] = '2';

        // 四周遍历
        find(grid, r - 1, c);
        find(grid, r, c + 1);
        find(grid, r + 1, c);
        find(grid, r, c - 1);
    }

    private boolean inGrid(char[][] grid, int r, int c) {
        return r >= 0 & r < grid.length && c >= 0 && c < grid[0].length;
    }

}
