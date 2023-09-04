package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/02/22
 * @description 托普利茨矩阵
 */
public class $766_IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
