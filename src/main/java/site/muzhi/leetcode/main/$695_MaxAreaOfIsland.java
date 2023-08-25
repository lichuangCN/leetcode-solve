package site.muzhi.leetcode.array;

/**
 * @author: lichuang
 * @date: 2020/03/15
 * @description:
 */

public class $695_MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result, dfs(i, j, grid));
            }
        }
        return result;
    }

    /**
     * @param i    行索引
     * @param j    列索引
     * @param grid
     * @return
     */
    public int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        // 此时grid[i][j] = 1，重置当前值，避免重复运算
        grid[i][j] = 0;
        int num = 1;
        // 广度搜索，向四个方向进行搜索，遇到0停止
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i + 1, j, grid);
        num += dfs(i, j - 1, grid);
        return num;
    }
}
