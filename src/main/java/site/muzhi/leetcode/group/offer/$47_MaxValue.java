package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2022/03/09
 * @description 剑指 Offer 47. 礼物的最大价值
 * <p>
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class $47_MaxValue {

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] buffer = new int[row][col];
        // 预处理
        buffer[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            buffer[i][0] = buffer[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            buffer[0][i] = buffer[0][i - 1] + grid[0][i];
        }

        // 遍历
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                buffer[i][j] = Math.max(buffer[i - 1][j], buffer[i][j - 1]) + grid[i][j];
            }
        }
        // 最后一行取最大值
        int max = buffer[row - 1][col - 1];
        for (int i = 1; i < col; i++) {
            max = Math.max(buffer[row - 1][i], max);
        }
        return max;
    }
}
