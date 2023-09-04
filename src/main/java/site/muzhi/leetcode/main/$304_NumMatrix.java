package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/03/02
 * @description 二维区域和检索 - 矩阵不可变
 */
public class $304_NumMatrix {

    class NumMatrix {

        int[][] presum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            presum = new int[row][col + 1];
            for (int i = 0; i < row; i++) {
                presum[i][0] = 0;
                for (int j = 1; j <= col; j++) {
                    presum[i][j] = matrix[i][j - 1] + presum[i][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += (presum[i][col2 + 1] - presum[i][col1]);
            }
            return sum;
        }
    }
}
