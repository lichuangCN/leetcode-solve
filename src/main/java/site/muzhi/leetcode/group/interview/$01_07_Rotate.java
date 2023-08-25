package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/01/23
 * @description 旋转矩阵
 */
public class $01_07_Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1.沿左上->右下的对角线进行交换
        // i 表示正在交换的行
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        // 2.沿垂直中线进行交换
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = t;
            }
        }
    }
}
