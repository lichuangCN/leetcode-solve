package site.muzhi.leetcode.group.tencent50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/11/07
 * 54.螺旋矩阵
 */
public class $54_spiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length - 1, cols = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();

        // 每一圈的起始位置
        int idx_r = 0, idx_c = 0;
        while (idx_r <= rows && idx_c <= cols) {
            // 上侧
            for (int i = idx_c; i <= cols; i++) {
                ans.add(matrix[idx_r][i]);
            }

            // 右侧
            for (int i = idx_r + 1; i <= rows; i++) {
                ans.add(matrix[i][cols]);
            }

            //
            if (idx_r < rows && idx_c < cols) {
                // 下侧
                for (int i = cols - 1; i >= idx_c; i--) {
                    ans.add(matrix[rows][i]);
                }
                // 左侧
                for (int i = rows - 1; i > idx_r; i--) {
                    ans.add(matrix[i][idx_c]);
                }
            }

            rows--;
            cols--;
            idx_r++;
            idx_c++;
        }
        return ans;
    }
}
