package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/04/08
 * @description 面试题 10.09. 排序矩阵查找
 * <p>
 * https://leetcode-cn.com/problems/sorted-matrix-search-lcci/
 */
public class $10_09_SearchMatrix {

    /**
     * 从右上向左下遍历查找
     * 时间复杂度O(N)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length, col = matrix[0].length;
        // x标识行，y标识列
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

    /**
     * 时间复杂度 O(M*logN)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length, col = matrix[0].length;
        while (row-- > 0) {
            if (target < matrix[row][0] || target > matrix[row][col - 1]) {
                continue;
            }
            int left = 0, right = col - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[row][mid] == target) {
                    return true;
                }
                if (matrix[row][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
