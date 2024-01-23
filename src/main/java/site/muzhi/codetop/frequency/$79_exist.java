package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/01/23
 * 79.单词搜索
 */
public class $79_exist {

    int[][] mv = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] used = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (travel(board, word, 0, r, c, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean travel(char[][] board, String word, int idx, int r, int c, boolean[][] used) {
        if (!inGrid(board, r, c) || used[r][c] || word.charAt(idx) != board[r][c]) {
            return false;
        }
        if (idx == word.length() - 1) {
            return word.charAt(idx) == board[r][c];
        }
        //
        used[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = mv[i][0] + r;
            int nc = mv[i][1] + c;
            if (travel(board, word, idx + 1, nr, nc, used)) {
                return true;
            }
        }
        used[r][c] = false;
        return false;
    }

    private boolean inGrid(char[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }
}
