package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/31
 * 79.单词搜索
 */
public class $79_exist {

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        char[] words = word.toCharArray();
        boolean[][] used = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (travel(board, words, used, 0, r, c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean travel(char[][] board, char[] word, boolean[][] used, int idx, int r, int c) {
        if (idx == word.length) {
            return true;
        }
        if (!inGrid(board, r, c) || used[r][c] || board[r][c] != word[idx]) {
            return false;
        }

        used[r][c] = true;
        // 向四周寻找
        boolean var1 = travel(board, word, used, idx + 1, r + 1, c);
        boolean var2 = travel(board, word, used, idx + 1, r - 1, c);
        boolean var3 = travel(board, word, used, idx + 1, r, c + 1);
        boolean var4 = travel(board, word, used, idx + 1, r, c - 1);
        used[r][c] = false;
        return var1 || var2 || var3 || var4;
    }

    private boolean inGrid(char[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }
}
