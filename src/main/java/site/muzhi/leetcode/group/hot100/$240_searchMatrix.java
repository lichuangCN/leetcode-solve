package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/27
 * 240.搜索二维矩阵 II
 */
public class $240_searchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int r = 0; r < rows; r++) {
            int left = 0, right = cols - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                int num = matrix[r][mid];
                if (num == target) {
                    return true;
                }
                if (num < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
