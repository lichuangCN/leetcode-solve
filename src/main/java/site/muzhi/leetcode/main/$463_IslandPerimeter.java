package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/10/30
 * @description 岛屿的周长
 */
public class $463_IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    num += count(i, j, grid);
                }
            }
        }
        return num ;
    }

    /**
     * 计算有多少个有效边
     *
     * @param i
     * @param j
     * @param grid
     * @return
     */
    private int count(int i, int j, int[][] grid) {
        // 当检测到0（海水）时，表示此边是有效的
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        // 相邻的是其他陆地块，表示此边是无效的
        if (grid[i][j] == 2) {
            return 0;
        }

        // 避免重复计算
        grid[i][j] = 2;
        int num = 0;
        // 向四周检测是否是海水
        num += count(i - 1, j, grid);
        num += count(i, j + 1, grid);
        num += count(i + 1, j, grid);
        num += count(i, j - 1, grid);
        return num;
    }
}
