package site.muzhi.leetcode.group.offerII;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/06/15
 * 76.数组中的第k大的数字（小顶堆）
 */
public class $76_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> x - y);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else {
                heap.add(num);
                heap.poll();
            }
        }
        return heap.poll();
    }
}
