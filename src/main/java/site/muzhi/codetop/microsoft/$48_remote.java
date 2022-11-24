package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/19
 * 48.旋转图像
 */
public class $48_remote {

    public void remate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        // 1 2 3
        // 4 5 6
        // 7 8 9
        int len = matrix.length;
        // 对角线翻转
        // ==>
        // 1 4 7
        // 2 5 8
        // 3 6 9
        int num = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                num = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = num;
            }
        }

        // 左右翻转
        // ==>
        // 7 4 1
        // 8 5 2
        // 9 6 3
        for (int i = 0; i < len; i++) {
            int left = 0, right = len - 1;
            while (left < right) {
                num = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = num;
                left++;
                right--;
            }
        }
    }
}
