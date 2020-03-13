package site.muzhi.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lichuang
 * @date: 2020/03/13
 * @description:
 */

public class $54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>(matrix[0].length * matrix.length);
        // 需要遍历列的范围
        int colStart = 0, colEnd = matrix[0].length - 1;
        // 需要遍历行的范围
        int rowStart = 0, rowEnd = matrix.length - 1;

        while (colStart <= colEnd && rowStart <= rowEnd) {
            // 前两个同样可以处理单行或单列
            // 上方一行
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            // 右侧一列
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            // 考虑有四条边的时候，避免出现遍历重复元素
            if (colStart < colEnd && rowStart < rowEnd) {
                // 下方一行
                for (int i = colEnd - 1; i > colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
                // 左侧一列
                for (int i = rowEnd; i > rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            // 设定下一次遍历的范围
            colStart++;
            colEnd--;
            rowStart++;
            rowEnd--;
        }
        return result;
    }
}
