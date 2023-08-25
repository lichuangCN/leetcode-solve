package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2021/02/25
 * @description
 */
public class $867_Transpose {

    public int[][] transpose(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] res = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
