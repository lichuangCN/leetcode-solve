package site.muzhi.leetcode.group.hot100;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/08/28
 * 56.合并区间
 */
public class $56_merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        int[][] ans = new int[intervals.length][2];
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] ints = intervals[i];
            if (i == 0) {
                ans[idx] = ints;
            } else if (ans[idx][1] < ints[0]) {
                // 新区间
                idx++;
                ans[idx] = ints;
            } else if (ans[idx][1] < ints[1]) {
                // 合并
                ans[idx][1] = ints[1];
            }
        }
        int[][] tar = new int[idx + 1][2];
        System.arraycopy(ans, 0, tar, 0, idx + 1);
        return tar;
    }
}
