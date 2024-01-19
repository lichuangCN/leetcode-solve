package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/05
 * 130.被围绕的区域
 */
public class $130_solve {

    int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {

        int rows = board.length, cols = board[0].length;
        boolean[][] mark = new boolean[rows][cols];

        // 以边界值寻找
        for (int i = 0; i < rows; i++) {
            travel(board, mark, i, 0);
            travel(board, mark, i, cols - 1);
        }
        for (int i = 0; i < cols; i++) {
            travel(board, mark, 0, i);
            travel(board, mark, rows - 1, i);
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!mark[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    public void travel(char[][] board, boolean[][] mark, int r, int c) {
        if (!inGrid(board, r, c) || mark[r][c] || board[r][c] == 'X') {
            return;
        }
        if (board[r][c] == 'O') {
            mark[r][c] = true;
        }
        for (int i = 0; i < 4; i++) {
            travel(board, mark, r + move[i][0], c + move[i][1]);
        }
    }

    private boolean inGrid(char[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }
}
