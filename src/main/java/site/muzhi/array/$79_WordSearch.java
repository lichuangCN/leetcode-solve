package site.muzhi.array;

/**
 * @author lichuang
 * @date 2020/09/11
 * @description 单词搜索
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class $79_WordSearch {

    private String word;

    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean[][] mark;
    private char[][] board;
    // 行数和列数
    private int row;
    private int col;

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        if (row == 0) {
            return false;
        }
        this.col = board[0].length;
        this.board = board;
        this.word = word;
        this.mark = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (search(i, k, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param x     行
     * @param y     列
     * @param index word上的第几个字符
     * @return
     */
    public boolean search(int x, int y, int index) {
        // 检索到字符串的最后一位
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        if (board[x][y] == word.charAt(index)) {
            // 当前位符合条件
            mark[x][y] = true;
            // 四个方向寻找下一位
            for (int i = 0; i < 4; i++) {
                int newX = x + move[i][0];
                int newY = y + move[i][1];
                // 在区域内并且没有遍历过
                if (inBoard(newX, newY) && !mark[newX][newY]) {
                    // 字符串下一位
                    if (search(newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            // 回溯重置当前位置
            mark[x][y] = false;
        }
        return false;
    }


    private boolean inBoard(int x, int y) {
        return (x >= 0) && (x < row) && (y >= 0) && (y < col);
    }
}
