package site.muzhi.leetcode.main;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/12/28
 * 456.132 模式
 */
public class $456_find132pattern {

    public boolean find132pattern(int[] nums) {

        // deque 内部维护了一个单调递减序列
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length, k = Integer.MIN_VALUE;

        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            // 需要动态更新num[k]的值
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                k = deque.pollLast();
            }
            deque.add(nums[i]);
        }
        return false;
    }
}
