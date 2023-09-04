package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/03/16
 * @description
 */
public class $59_GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int up = 0, down = n - 1, left = 0, right = n - 1;
        // 右-下-左-上
        int[][] dest = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int idx = 1, curr = 0;

        int[][] matrix = new int[n][n];
        int x = 0, y = 0;

        while (idx <= n * n) {
            matrix[x][y] = idx;
            if (curr == 0 && y == right) {
                curr++;
                up++;
            } else if (curr == 1 && x == down) {
                curr++;
                right--;
            } else if (curr == 2 && y == left) {
                curr++;
                down--;
            } else if (curr == 3 && x == up) {
                curr++;
                left++;
            }
            curr %= 4;
            x += dest[curr][0];
            y += dest[curr][1];
            idx++;
        }
        return matrix;
    }
}
