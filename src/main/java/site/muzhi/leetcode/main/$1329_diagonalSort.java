package site.muzhi.leetcode.main;

import java.util.*;

/**
 * @author lichuang
 * @date 2023/12/28
 * 1329.将矩阵按对角线排序
 */
public class $1329_diagonalSort {

    public int[][] diagonalSort(int[][] mat) {

        Map<Integer, List<Integer>> group = new HashMap<>();
        int rows = mat.length, cols = mat[0].length;

        // 分组
        // 左对角线 r - c 相等的 是一组
        // 右对角线 r + c 相等的 是一组
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                List<Integer> item = group.getOrDefault(r - c, new ArrayList<>());
                item.add(mat[r][c]);
                group.put(r - c, item);
            }
        }

        // 排序
        group.forEach((k, v) -> {
            Collections.sort(v);
        });

        // 重新填充
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                List<Integer> item = group.get(r - c);
                mat[r][c] = item.get(0);
                // 移除填充过的元素
                item.remove(0);
            }
        }
        return mat;
    }
}
