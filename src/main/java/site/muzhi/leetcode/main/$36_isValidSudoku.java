package site.muzhi.leetcode.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lichuang
 * @date 2024/01/02
 * 36.有效的数独
 */
public class $36_isValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length, cols = board[0].length;
        Map<Integer, Set<Character>> rowsMap = new HashMap<>();
        Map<Integer, Set<Character>> colsMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            rowsMap.put(i, new HashSet<>());
        }
        for (int i = 0; i < cols; i++) {
            colsMap.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            boxMap.put(i, new HashSet<>());
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = board[r][c];
                if (ch != '.') {
                    // box区域索引计算
                    int boxIdx = (r / 3) * 3 + c / 3;
                    if (rowsMap.get(r).contains(ch) || colsMap.get(c).contains(ch) || boxMap.get(boxIdx).contains(ch)) {
                        return false;
                    }
                    rowsMap.get(r).add(ch);
                    colsMap.get(c).add(ch);
                    boxMap.get(boxIdx).add(ch);
                }
            }
        }

        return true;
    }
}
