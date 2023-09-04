package site.muzhi.leetcode.main;

/**
 * @author: lichuang
 * @date: 2020/03/26
 * @description:
 */

public class $999_VailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        if (board.length == 0) {
            return 0;
        }
        // 国际象棋 8x8
        int row = 8, col = 8;
        // 查找白车的位置
        int Rrow = 0, Rcol = 0, result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ('R' == board[i][j]) {
                    Rrow = i;
                    Rcol = j;
                    break;
                }
            }
        }
        // 向四个方向查找
        // 1.正上方
        for (int i = Rrow-1; i >= 0; i--) {
            if ('p' == board[i][Rcol]) {
                result++;
                break;
            }
            if ('B' == board[i][Rcol]) {
                break;
            }
        }
        // 2.正下方
        for (int i = Rrow+1; i < row; i++) {
            if ('p' == board[i][Rcol]) {
                result++;
                break;
            }
            if ('B' == board[i][Rcol]) {
                break;
            }
        }
        // 3.正右方
        for (int i = Rcol+1; i < col; i++) {
            if ('p' == board[Rrow][i]) {
                result++;
                break;
            }
            if ('B' == board[Rrow][i]) {
                break;
            }
        }
        //4.正左方
        for (int i = Rcol-1; i >= 0; i--) {
            if ('p' == board[Rrow][i]) {
                result++;
                break;
            }
            if ('B' == board[Rrow][i]) {
                break;
            }
        }
        return result;
    }
}
