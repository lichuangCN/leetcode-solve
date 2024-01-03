package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/02
 * 48.旋转图像
 */
public class $48_rotate {

    public void rotate(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        // 左对角线对称
        for (int r = 0; r < rows; r++) {
            for (int c = r; c < cols; c++) {
                swap(matrix, r, c, c, r);
            }
        }

        // 中轴线对称
        for (int i = 0; i < rows; i++) {
            int left = 0, right = cols - 1;
            while (left < right) {
                swap(matrix, i, left, i, right);
                left++;
                right--;
            }
        }
    }

    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int t = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = t;
    }
}
