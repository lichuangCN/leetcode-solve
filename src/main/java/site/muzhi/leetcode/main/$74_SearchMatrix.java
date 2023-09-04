package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/03/30
 * @description
 */
public class $74_SearchMatrix {


    /**
     * 全局二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix_1(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / col][mid % col];
            if (val == target) {
                return true;
            }
            if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 二次二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }

        // 查找所在行
        int up = 0, down = row - 1;
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target) {
                up = mid + 1;
            } else {
                down = mid - 1;
            }
        }
        // 所在行
        int r = down;
        int left = 0, right = col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[r][mid] == target) {
                return true;
            }
            if (matrix[r][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
