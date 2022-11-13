package site.muzhi.codetop.microsoft;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2022/11/13
 * @description 215. 数组中的第K个最大元素
 * <p>
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class $215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0 || k > nums.length) {
            return -1;
        }
        // 小顶堆 最小值在堆顶
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> x - y);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() != nums[i]) {
                // 先添加元素，在移除堆顶元素，新的堆顶元素就是第k小的元素
                minHeap.add(nums[i]);
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
