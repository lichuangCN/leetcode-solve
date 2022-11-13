package site.muzhi.itbook.bk_1.chapter_1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2022/10/30
 * @description leetcode:https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class Q7 {

    /**
     * 暴力解决：超时 时间复杂度 n*k
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        int left = 0, right = k - 1;
        while (right < nums.length) {
            int max = nums[left];
            for (int i = left; i <= right; i++) {
                max = Math.max(max, nums[i]);
            }
            ans[left] = max;
            left++;
            right++;
        }
        return ans;
    }

    /**
     * 时间复杂度 n*logk
     */
    public int[] maxSlidingWindow_2(int[] nums, int k) {
        // int[索引][值]
        // 大顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        int idx = 0;
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{i, nums[i]});
            // 窗口中的元素个数满足窗口大小后开始计算
            if (i >= k - 1) {
                // i-k+1 窗口最左边元素位置
                while (queue.peek()[0] < i - k + 1) {
                    queue.poll();
                }
                ans[idx++] = queue.peek()[1];
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow_3(int[] nums, int k) {

        // [索引]: nums中最大值的索引
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            // 窗口中的元素个数满足窗口大小后开始计算
            if (i >= k - 1) {
                while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
