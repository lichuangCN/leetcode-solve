package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/11/23
 * @description 矩阵中的路径
 */
public class $12_Exist {

    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // 遍历路径
    private boolean[][] movedMark;
    // 行数/列数
    private int row, col;

    public boolean exist(char[][] board, String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        if ((row = board.length) == 0 || (col = board[0].length) == 0) {
            return false;
        }
        movedMark = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (move(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean move(char[][] board, String word, int x, int y, int index) {
        // 字符串最后一位
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        // 如果当前位置符合
        if (board[x][y] == word.charAt(index)) {
            movedMark[x][y] = true;
            // 向四周寻找
            for (int i = 0; i < 4; i++) {
                int newX = x + move[i][0];
                int newY = y + move[i][1];
                if (inBoard(newX, newY) && !movedMark[newX][newY]) {
                    if (move(board, word, newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            // 重置
            movedMark[x][y] = false;
        }
        return false;
    }

    private boolean inBoard(int x, int y) {
        return (x >= 0) && (x < row) && (y >= 0) && (y < col);
    }
}
