package site.muzhi.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2020/11/04
 * @description 插入区间
 */
public class $57_InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(intervals.length + 1);
        int left = newInterval[0], right = newInterval[1];
        // 是否合并完成
        boolean placed = false;
        for (int[] interval : intervals) {
            // 新区间在此区间的左侧
            if (interval[0] > right) {
                if (!placed) {
                    list.add(new int[]{left, right});
                    // 已经合并完成
                    placed = true;
                }
                list.add(interval);
            } else if (interval[1] < left) {
                // 新区间在此区间的右侧
                list.add(interval);
            } else {
                // 跨区间,选择最广的区间长度
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        // 跨多个区间,多个合并后的区间的范围
        if (!placed) {
            list.add(new int[]{left, right});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
