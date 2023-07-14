package site.muzhi.codetop.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/13
 * 54.螺旋矩阵
 */
public class $54_spiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 每一圈的行、列边界（每一圈之后动态调整）
        int row = matrix.length - 1, col = matrix[0].length - 1;
        // 每一圈起始点位（每一圈之后动态调整）
        int ptr_r = 0, ptr_c = 0;

        List<Integer> ans = new ArrayList<>(row * col);
        while (ptr_r <= row && ptr_c <= col) {
            // 上侧
            for (int i = ptr_c; i <= col; i++) {
                ans.add(matrix[ptr_r][i]);
            }

            // 右侧
            for (int i = ptr_r + 1; i <= row; i++) {
                ans.add(matrix[i][col]);
            }

            // 多行情况
            if (ptr_r < row && ptr_c < col) {
                // 下侧
                for (int i = col - 1; i >= ptr_c; i--) {
                    ans.add(matrix[row][i]);
                }

                // 左侧
                for (int i = row - 1; i > ptr_r; i--) {
                    ans.add(matrix[i][ptr_c]);
                }
            }
            // 调整边界值和起始值
            row--;
            col--;
            ptr_r++;
            ptr_c++;
        }
        return ans;
    }
}
