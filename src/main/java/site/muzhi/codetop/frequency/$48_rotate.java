package site.muzhi.codetop.frequency;

/**
 * @auth lichuang
 * @data 2023/07/31
 * 48.旋转图像
 */
public class $48_rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 左右旋转
        int i = 0;
        for (int r = 0; r < n; r++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                swap(matrix, r, left, r, right);
                left++;
                right--;
            }
        }

        // 对称旋转
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n - r; c++) {
                swap(matrix, r, c, n - c - 1, n - r - 1);
            }
        }
    }

    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int var = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = var;
    }
}
