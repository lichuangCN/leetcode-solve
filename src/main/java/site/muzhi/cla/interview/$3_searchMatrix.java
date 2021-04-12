package site.muzhi.cla.interview;

/**
 * @author lichuang
 * @date 2021/04/12
 * @description 搜索二维矩阵 II
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xmlwi1/
 */
public class $3_searchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int x = 0, y = col - 1;
        while (x < row && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
