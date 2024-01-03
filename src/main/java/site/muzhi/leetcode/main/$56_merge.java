package site.muzhi.leetcode.main;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2024/01/02
 * 56.合并区间
 */
public class $56_merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int[][] sentry = new int[intervals.length][2];
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] it = intervals[i];
            if (i == 0) {
                sentry[idx++] = it;
            } else {
                if (sentry[idx - 1][1] >= it[0]) {
                    if (sentry[idx - 1][1] < it[1]) {
                        sentry[idx - 1][1] = it[1];
                    }
                } else {
                    sentry[idx++] = it;
                }
            }
        }

        //
        int[][] ans = new int[idx][2];
        for (int i = 0; i < idx; i++) {
            ans[i] = sentry[i];
        }
        return ans;
    }
}
