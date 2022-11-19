package site.muzhi.codetop.microsoft;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2022/11/19
 * 56.合并区间
 */
public class $56_merge {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        // [1,3],[2,6].[8.10]
        // 根据区间起始位置排序
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        int[][] ans = new int[intervals.length][2];
        int idx = -1;

        // 遍历
        for (int[] interval : intervals) {
            // 当前区间的起始位置不在前面区间内
            if (idx == -1 || interval[0] > ans[idx][1]) {
                ans[++idx] = interval;
            } else {
                // 合并区间
                ans[idx][1] = Math.max(ans[idx][1], interval[1]);
            }
        }

        // 因为合并后的区间数可能会减少 idx + 1 = 合并后的区间数
        return Arrays.copyOf(ans, idx + 1);
    }
}
