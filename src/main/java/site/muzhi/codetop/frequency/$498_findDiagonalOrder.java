package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/01/22
 * 498.对角线遍历
 */
public class $498_findDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length, cnt = rows * cols;
        int[] ans = new int[cnt];

        // dir = 1  左下 -> 右上
        // dir = -1 右上 -> 左下
        int idx = 0, dir = 1, x = 0, y = 0;
        while (idx != cnt) {
            ans[idx++] = mat[x][y];
            int nx = x, ny = y;
            if (dir == 1) {
                nx = x - 1;
                ny = y + 1;
            } else {
                nx = x + 1;
                ny = y - 1;
            }

            // 越界，需要变更方向
            if (idx < cnt && (nx < 0 || nx >= rows || ny < 0 || ny >= cols)) {
                if (dir == 1) {
                    // y + 1 < cols: 在矩阵上半部分
                    nx = y + 1 < cols ? x : x + 1;
                    ny = y + 1 < cols ? y + 1 : y;
                } else {
                    // x + 1 < rows: 在矩阵上半部分
                    nx = x + 1 < rows ? x + 1 : x;
                    ny = x + 1 < rows ? y : y + 1;
                }
                dir *= -1;
            }
            x = nx;
            y = ny;
        }
        return ans;
    }
}
