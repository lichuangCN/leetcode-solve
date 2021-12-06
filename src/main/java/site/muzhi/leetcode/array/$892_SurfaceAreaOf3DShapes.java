package site.muzhi.leetcode.array;

/**
 * @author: lichuang
 * @date: 2020/03/25
 * @description: 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 */

public class $892_SurfaceAreaOf3DShapes {
    /**
     * 做好加法和减法
     * 什么时候做加法：当遇到位置存在正方形时，计算此时整个正方形的面积。
     * 什么时候做减法：当检测到当前位置四个方向(实现时可以只需考虑两个方向进行优化)存在重叠时
     * 减去重叠部分的面积。
     *
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 记录当前位置的方块数
                int count = grid[i][j];
                // 当前位置没有正方形，直接跳过
                if (count == 0) {
                    continue;
                }
                // 每个方块贡献四个侧面+顶部和底部两个
                result += (count * 4) + 2;
                // 处理当前位置与正下方位置的重叠部分(直接减去两个位置重叠的面积和)
                result -= (i + 1 < row) ? Math.min(count, grid[i + 1][j]) * 2 : 0;
                // 处理当前位置与正右方位置的重叠部分(直接减去两个位置重叠的面积和)
                result -= (j + 1 < col) ? Math.min(count, grid[i][j + 1]) * 2 : 0;
            }
        }
        return result;
    }
}
