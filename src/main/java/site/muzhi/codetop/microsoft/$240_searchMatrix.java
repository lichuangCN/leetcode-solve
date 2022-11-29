package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/29
 * @description 240. 搜索二维矩阵 II
 */
public class $240_searchMatrix {

    /**
     * 逐层二分查找
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            int left = 0, right = cols - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (matrix[i][mid] == target) {
                    return true;
                }
                if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    /**
     * dfs 左上角开始寻找
     */
    public boolean searchMatrix_2(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, l = cols - 1;
        while (r < rows && l >= 0) {
            if (matrix[r][l] == target) {
                return true;
            }
            if (matrix[r][l] > target) {
                l--;
            } else {
                r++;
            }
        }
        return false;
    }
}
