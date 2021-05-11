package site.muzhi.cla.primaryalgorithm.chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 有效的数独
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
 */
public class $10_isValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int r = 0; r < 9; r++) {
            // 第[r]行元素的集合
            Set<Character> row = new HashSet<>();
            // 第[r]列元素的集合
            Set<Character> col = new HashSet<>();

            /* 3*3方格位置：
             * idx 0 1 2
             *  0  0-1-2
             *  1  3-4-5
             *  2  6-7-8
             */
            // 第[r]个方格中元素的集合
            Set<Character> box = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.' && !row.add(board[r][c])) {
                    return false;
                }
                if (board[c][r] != '.' && !col.add(board[c][r])) {
                    return false;
                }

                // 计算3*3方格位置
                // 这个我真的算不出来，绝妙的方程
                // 推算：[方格位置的描述参考上方3*3方格位置的描述]
                // 1.(r/3): 标识目标方格在3*3方格位置的哪一行,c/3标识方格中的某一行
                // (r/3)*3+c/3, 即可以精确定位到9*9数组中的某一行
                // 2.(r%3): 标识目标方格在3*3方格位置的哪一列,c%3标识方格中的某一列
                // (r/3)*3+c/3, 即可以精确定位到9*9数组中的某一列
                // 3.通过1、2可以确定某个位置的元素
                int x = (r / 3) * 3 + c / 3;
                int y = (r % 3) * 3 + c % 3;
                if (board[x][y] != '.' && !box.add(board[x][y])) {
                    return false;
                }
            }
        }
        return true;
    }
}
