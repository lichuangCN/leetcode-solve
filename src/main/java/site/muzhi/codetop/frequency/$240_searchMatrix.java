package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/02
 * 240.搜索二维矩阵 II
 */
public class $240_searchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        if (matrix[0][0] > target || matrix[rows - 1][cols - 1] < target) {
            return false;
        }
        for (int r = 0; r < rows; r++) {
            int left = 0, right = cols - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[r][mid] == target) {
                    return true;
                }
                if (matrix[r][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
