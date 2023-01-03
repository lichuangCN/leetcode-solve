package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/03
 * 79 单词搜索
 */
public class $79_exist {

    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int rows, cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        boolean[][] used = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (travel(used, board, r, c, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean travel(boolean[][] used, char[][] board, int r, int c, int idx, String word) {
        if (idx == word.length() - 1) {
            return word.charAt(idx) == board[r][c];
        }
        // 当前字母符合
        if (word.charAt(idx) == board[r][c]) {
            used[r][c] = true;
            // 向周围寻找
            for (int i = 0; i < 4; i++) {
                int newR = move[i][0] + r;
                int newC = move[i][1] + c;
                if (inBoard(newR, newC) && !used[newR][newC]) {
                    if (travel(used, board, newR, newC, idx + 1, word)) {
                        return true;
                    }
                }
            }
            used[r][c] = false;
        }
        return false;
    }

    private boolean inBoard(int r, int c) {
        return 0 <= r && r < rows && 0 <= c && c < cols;
    }
}
