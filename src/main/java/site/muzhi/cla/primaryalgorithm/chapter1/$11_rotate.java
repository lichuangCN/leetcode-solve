package site.muzhi.cla.primaryalgorithm.chapter1;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 旋转图像
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhhkv/
 */
public class $11_rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1.沿着左上到右下的对角线交换元素位置
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        int mid = n >> 1;
        // 2.沿着中轴左右交换元素位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = t;
            }
        }
    }
}
