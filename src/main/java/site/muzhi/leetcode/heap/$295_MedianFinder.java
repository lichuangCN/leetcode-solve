package site.muzhi.leetcode.heap;

import java.util.PriorityQueue;

/**
 * Author: lichuang
 * Date: 2020/02/08
 * Description:
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 算法思路：设计两个堆：最大堆和最小堆，各自维护一半的数据，并且最大堆堆顶的值小于最小堆堆顶的值
 * 并且元素个数总和为奇数时，保证最大堆的元素个数比最小堆元素多一个，此时中位数为最大堆的堆顶元素
 * 1.元素首先进入最小堆，再将最小堆的堆顶元素取出放入最大堆（可以保证最大堆堆顶元素小于最小堆堆顶元素）
 * 2.比较元素个数，为奇数时将元素放入最小堆
 */
public class $295_MedianFinder {


    class MedianFinder {
        /**
         * initialize your data structure here.
         */
        PriorityQueue<Integer> maxheap;
        PriorityQueue<Integer> minheap;
        int count;

        public MedianFinder() {
            count = 0;
            maxheap = new PriorityQueue<>((x, y) -> y - x);
            minheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            count++;
            // 先入最大堆，后入最小堆
            maxheap.offer(num);
            minheap.offer(maxheap.poll());
            // 调整两个堆得元素个数
            if ((count % 2) != 0) {
                maxheap.offer(minheap.poll());
            }
        }

        public double findMedian() {
            if ((count % 2) == 0) {
                // 如果是偶数，则是两个堆顶之和的1/2
                return (double) (maxheap.peek() + minheap.peek()) / 2;
            } else {
                // 如果是奇数，则是最
                return (double) maxheap.peek();
            }
        }
    }
}