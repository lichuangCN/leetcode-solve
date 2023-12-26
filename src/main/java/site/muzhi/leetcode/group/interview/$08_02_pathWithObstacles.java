package site.muzhi.leetcode.group.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/12/22
 * 08.02 迷路的机器人
 */
public class $08_02_pathWithObstacles {

    boolean find = false;

    int[][] move = {{0, 1}, {1, 0}};

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        boolean[][] used = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        LinkedList<List<Integer>> ans = new LinkedList<>();

        travel(ans, 0, 0, obstacleGrid, used);
        return ans;
    }

    private void travel(LinkedList<List<Integer>> ans, int r, int c, int[][] grid, boolean[][] used) {
        if (find) {
            return;
        }

        if (!inGrid(r, c, grid) || grid[r][c] == 1 || used[r][c]) {
            return;
        }

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            ans.add(Arrays.asList(r, c));
            find = true;
            return;
        }

        used[r][c] = true;
        ans.add(Arrays.asList(r, c));
        // 向右或向下寻找
        for (int i = 0; i < 2; i++) {
            int nextR = r + move[i][0];
            int nextC = c + move[i][1];
            travel(ans, nextR, nextC, grid, used);
        }
        // 回溯 移除原来的路径
        if (!find) {
            ans.removeLast();
        }
    }

    private boolean inGrid(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
