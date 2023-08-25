package site.muzhi.leetcode.group.offerII;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/06/12
 * 74.合并区间
 */
public class $74_merge {

    public int[][] merge(int[][] intervals) {
        // 正序排序
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int[][] ans = new int[intervals.length][2];
        // 初始化第一个元素位置
        int idx = 0;
        ans[0] = intervals[0];
        // 遍历后续
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] > ans[idx][1]) {
                // 新的时间段
                ans[++idx] = interval;
            } else {
                ans[idx][1] = Math.max(ans[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(ans, idx + 1);
    }
}
