package site.muzhi.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lichuang
 * @date: 2020/03/06
 * @description: 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */

public class $57_FindContinuousSequence {

    /**
     * 滑动窗口解决方案
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[0][0];
        }

        // 滑动窗口左右边界
        int left = 1, right = 1;
        // 滑动窗口内的值
        int sum = 1;
        // 滑动的边界
        int limit = (target + 1) / 2;
        // 存放结果数组
        List<int[]> list = new ArrayList<>();
        while (left < limit) {
            // 刚好是目标值
            if (sum == target) {
                // 保存当前的一个解
                int[] res = new int[right - left + 1];
                for (int i = 0; i < res.length; i++) {
                    res[i] = left + i;
                }
                list.add(res);
                // 窗口左侧向右移动
                sum -= left;
                left++;
            }
            // 当前之和大于目标值
            if (sum > target) {
                // 窗口左侧向右移动
                sum -= left;
                left++;
            }
            // 当前之后小于目标值
            if (sum < target) {
                // 扩大滑动窗口
                right++;
                sum += right;
            }
        }
        // 重置返回结果
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
