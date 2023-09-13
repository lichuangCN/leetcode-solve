package site.muzhi.leetcode.group.hot100;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/09/13
 * 215.数组中的第k个最大元素
 */
public class $215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
