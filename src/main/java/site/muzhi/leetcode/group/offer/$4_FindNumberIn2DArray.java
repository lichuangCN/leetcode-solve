package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2022/03/03
 * @description 剑指 Offer 04. 二维数组中的查找
 * <p>
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class $4_FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;

        // 从右上向左下遍历查询
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
