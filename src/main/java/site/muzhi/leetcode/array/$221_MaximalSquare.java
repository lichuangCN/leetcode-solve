package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2020/05/08
 * @description 在一个由 0 和 1 组成的二维矩阵内，
 * 找到只包含 1 的最大正方形，并返回其面积。
 */
public class $221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 最大正方形的边长
        int maxLen = 0;
        // 动态规划矩阵
        int dp[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    // 边界处理
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        /*
                         * 状态转移方程
                         * 即以正方形的右下角元素为基点，其最大正方形的边长取决于
                         * 其左方、左上方、上方，三个位置
                         */
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    // 记录最大边长
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
