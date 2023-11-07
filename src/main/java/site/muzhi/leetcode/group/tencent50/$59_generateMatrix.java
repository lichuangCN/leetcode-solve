package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/07
 * 59.螺旋矩阵 II
 */
public class $59_generateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rows = n - 1, cols = n - 1, idx_r = 0, idx_c = 0, idx = 1;
        while (idx_r <= rows && idx_c <= cols) {
            // 上侧
            for (int i = idx_c; i <= cols; i++) {
                matrix[idx_r][i] = idx++;
            }
            // 右侧
            for (int i = idx_r + 1; i <= rows; i++) {
                matrix[i][cols] = idx++;
            }
            if (idx_r < rows && idx_c < cols) {
                // 下侧
                for (int i = cols - 1; i >= idx_c; i--) {
                    matrix[rows][i] = idx++;
                }
                // 左侧
                for (int i = rows - 1; i > idx_r; i--) {
                    matrix[i][idx_c] = idx++;
                }
            }
            rows--;
            cols--;
            idx_r++;
            idx_c++;
        }
        return matrix;
    }
}
