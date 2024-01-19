package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/03
 * 73.矩阵置零
 */
public class $73_setZeroes {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        // 标记当前行/列 出现0
        boolean[] rowMake = new boolean[rows];
        boolean[] colMake = new boolean[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    rowMake[r] = true;
                    colMake[c] = true;
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rowMake[r] || colMake[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
