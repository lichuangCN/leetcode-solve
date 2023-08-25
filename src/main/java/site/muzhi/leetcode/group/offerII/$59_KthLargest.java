package site.muzhi.leetcode.group.offerII;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/05/24
 * 59.数据流的第K大数值
 */
public class $59_KthLargest {

    class KthLargest {

        PriorityQueue<Integer> heap;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            heap.offer(val);
            if (heap.size() > k) {
                heap.poll();
            }
            return heap.peek();
        }
    }
}
