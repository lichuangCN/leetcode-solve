package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2023/08/24
 * 48.旋转图像
 */
public class $48_rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 左右对称
        for (int row = 0; row < n; row++) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                swap(matrix, row, l, row, r);
            }
        }

        // 斜对角对称 (r1,c1), (r2,c2)
        // r1 + c2 = n - 1
        // c1 + r2 = n - 1
        for (int r = 0; r < n; r++) {
            for (int j = 0; j < n - r - 1; j++) {
                swap(matrix, r, j, n - j - 1, n - r - 1);
            }
        }
    }

    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int t = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = t;
    }
}
