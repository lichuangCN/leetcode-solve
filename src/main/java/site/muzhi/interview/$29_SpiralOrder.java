package site.muzhi.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lichuang
 * @date: 2020/03/17
 * @description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */

public class $29_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 输出上方一行
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            // 输出右侧一列
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            // 如果存在多行多列
            if (rowStart < rowEnd && colStart < colEnd) {
                // 输出下方一行
                for (int i = colEnd - 1; i >= colStart + 1; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                // 输出左侧一列
                for (int i = rowEnd; i >= rowStart + 1; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
