package site.muzhi.array;

import java.util.LinkedList;

/**
 * @author: lichuang
 * @date: 2020/03/29
 * @description: 你现在手里有一份大小为 N x N 的『地图』（网格） grid，
 * 上面的每个『区域』（单元格）都用 0 和 1 标记好了。
 * 其中 0 代表海洋，1 代表陆地，
 * 你知道距离陆地区域最远的海洋区域是是哪一个吗？请
 * 返回该海洋区域到离它最近的陆地区域的距离。
 * <p>
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * <p>
 * 同994题目：烂橘子问题
 */


public class $1162_AsFarFromLandAsPossible {

    /**
     * 位置类
     */
    class Point {

        int row;
        int col;
        int distance;

        public Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public int maxDistance(int[][] grid) {
        int row = grid.length, col = row;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        LinkedList<Point> queue = new LinkedList<>();

        // 记录最远距离
        int maxDistance = 0;
        // 遍历寻找所有的陆地
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Point(i, j, 0));
                }
            }
        }
        // 海洋的个数
        int seaCount = row * row - queue.size();
        while (!queue.isEmpty()) {
            int count = queue.size();
            Point point = queue.poll();
            int r = point.row, c = point.col, distance = point.distance;
            // 向上右下左四个方向搜索
            for (int i = 0; i < 4; i++) {
                int newRow = r + dr[i];
                int newCol = c + dc[i];
                if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col || grid[newRow][newCol] != 0) {
                    continue;
                }
                grid[newRow][newCol] = distance + 1;
                queue.offer(new Point(newRow, newCol, distance + 1));
                maxDistance = distance + 1;
            }
        }
        return (maxDistance == 0) ? -1 : maxDistance;
    }
}
