package site.muzhi.codetop.frequency;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/07/18
 * 56.合并区间
 */
public class $56_merge {

    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int[][] ans = new int[intervals.length][2];
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 初始值
            if (i == 0) {
                ans[idx] = interval;
                continue;
            }
            // case 1: 合并[1,2], [3,4]  ==> [1,2],[3,4]
            if (ans[idx][1] < interval[0]) {
                idx++;
                ans[idx] = interval;
                continue;
            }
            // case 2: 合并[1,3], [2,4] ==> [1,4]
            if (ans[idx][1] < interval[1]) {
                ans[idx][1] = interval[1];
            }
            // case 3: 合并[1,4], [2,3] ==> [1,4]
            // 不需要任何处理，因为当前指向就是 [1,4]
        }
        // idx 指向的是索引, 实际数组长度应该是 [len = 索引+1]
        int[][] tar = new int[idx + 1][2];
        System.arraycopy(ans, 0, tar, 0, idx + 1);
        return tar;
    }
}
