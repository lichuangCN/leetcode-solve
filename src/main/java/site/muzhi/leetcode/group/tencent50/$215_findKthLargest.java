package site.muzhi.leetcode.group.tencent50;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/11/08
 * 215.数组中的第k个最大元素
 */
public class $215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            if (heap.size() != k) {
                heap.add(num);
            } else {
                if (heap.peek() < num) {
                    heap.poll();
                    heap.add(num);
                }
            }
        }
        return heap.peek();
    }
}
