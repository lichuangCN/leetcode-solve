package site.muzhi.leetcode.clazz.interview.chapter3;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2021/04/13
 * @description 数据流的中位数
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xalff2/
 */
public class $3_MedianFinder {

    class MedianFinder {

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        int count = 0;

        public MedianFinder() {
            // 前半段元素
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            // 后半段元素
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            count++;
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
            if ((count & 1) == 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if ((count & 1) == 1) {
                return (double) minHeap.peek();
            } else {
                return (double)(maxHeap.peek() + minHeap.peek()) / 2;
            }
        }
    }
}
