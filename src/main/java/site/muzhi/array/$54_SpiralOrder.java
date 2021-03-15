package site.muzhi.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/03/15
 * @description
 */
public class $54_SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>(row * col);

        // 边界
        int up = 0, down = row - 1, right = col - 1, left = 0;
        // 右-下-左-上
        int[][] dest = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, curr = 0;

        while (res.size() < row * col) {
            res.add(matrix[x][y]);
            if (curr == 0 && y == right) {
                // 向右移动并抵达右边界
                curr++;
                // 上边界下移
                up++;
            } else if (curr == 1 && x == down) {
                // 向下移动并抵达下边界
                curr++;
                right--;
            } else if (curr == 2 && y == left) {
                // 向左移动并抵达左边界
                curr++;
                down--;
            } else if (curr == 3 && x == up) {
                // 向上移动并抵达上边界
                curr++;
                left++;
            }
            curr %= 4;
            x += dest[curr][0];
            y += dest[curr][1];
        }
        return res;
    }
}
