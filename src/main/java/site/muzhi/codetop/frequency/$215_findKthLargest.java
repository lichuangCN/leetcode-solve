package site.muzhi.codetop.frequency;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/07/10
 * 215.数组中的第k个最大元素
 */
public class $215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> x - y);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
