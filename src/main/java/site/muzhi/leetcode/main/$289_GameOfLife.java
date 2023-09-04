package site.muzhi.leetcode.main;

/**
 * @author: lichuang
 * @date: 2020/04/02
 * @description: 生命游戏
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：
 * 1 即为活细胞（live），或 0 即为死细胞（dead）。
 * <p>
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 */

public class $289_GameOfLife {

    private final int[] dRow = {-1, -1, -1, 0, 1, 1, 1, 0};
    private final int[] dCol = {-1, 0, 1, 1, 1, 0, -1, -1};

    /**
     * 最后一位表示细胞的当前状态，倒数第二位表示细胞更新后的状态
     * 0:[00] -> 表示当前和下一个状态都是死亡
     * 1:[01] -> 表示当前存活（1），下一次状态是死亡（0）
     * 2:[10] -> 表示当前死亡（0），下一次状态是复活（1）
     * 3:[11] -> 表示当前和下一个状态都是存活
     */
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int newRow = r + dRow[k];
                    int newCol = c + dCol[k];
                    if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col) {
                        continue;
                    }
                    // 周围的细胞是存活状态，需要用最后一位状态来判断
                    live = ((board[newRow][newCol]&1) == 1) ? live + 1 : live;
                }
                // 当前细胞为存活状态时
                if (board[r][c] == 1) {
                    // 当前细胞的下一个更新变成死亡状态
                    if (live < 2 || live > 3) {
                        board[r][c] = 1;
                    }
                    // 当前细胞下一个更新保持存活状态
                    if (live == 2 || live == 3) {
                        board[r][c] = 3;
                    }
                }
                // 当前细胞为死亡状态时
                if (board[r][c] == 0) {
                    // 当前细胞下一个状态是复活状态
                    if (live == 3) {
                        board[r][c] = 2;
                    }
                    // 否则什么也不做，下一次更新保持死亡的状态
                }
            }
        }
        // 最后一位去掉，倒数第二位变为更新后的状态
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                board[r][c] >>= 1;
            }
        }
    }
}
