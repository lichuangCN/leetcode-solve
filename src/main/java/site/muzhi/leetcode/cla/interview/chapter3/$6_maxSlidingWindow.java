package site.muzhi.leetcode.cla.interview.chapter3;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2021/04/22
 * @description 滑动窗口最大值
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xatgye/
 */
public class $6_maxSlidingWindow {

    /**
     * 单调队列存储滑动过的窗口的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }

        int len = nums.length;
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0, left = 1 - k; right < len; right++, left++) {
            int val = nums[right];
            // 删除queue中对应的窗口中的第一个元素
            if (left > 0 && nums[left - 1] == queue.peekFirst()) {
                queue.removeFirst();
            }
            // 队列递减
            while (!queue.isEmpty() && queue.peekLast() < val) {
                queue.removeLast();
            }
            queue.addLast(val);
            if (left >= 0) {
                res[left] = queue.peekFirst();
            }
        }
        return res;
    }


    /**
     * 暴力枚举
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        // 处理前k个数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        res[0] = max;

        // 迭代遍历后面的数字
        for (int i = 1; i <= len - k; i++) {
            max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}
