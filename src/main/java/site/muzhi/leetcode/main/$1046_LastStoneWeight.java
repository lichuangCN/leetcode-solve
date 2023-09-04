package site.muzhi.leetcode.main;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: LiChuang
 * @date: 2020/02/29
 * @description: 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。
 * 假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class $1046_LastStoneWeight {

    /**
     * 本地方法, 构建最大堆
     * 剩余的元素应在[0,heapSize]范围内
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {

        if (stones.length == 0) {
            return 0;
        }
        // 剩余元素的数目
        int heapSize = stones.length;
        buildHeap(stones, heapSize);
        while (heapSize > 1) {
            // 取出当前堆最大元素
            int x = stones[0];
            // 调整堆，以取出当前堆第二大元素
            stones[0] = stones[heapSize - 1];
            adjust(stones, 0, heapSize - 1);
            int y = stones[0];
            if (x == y) {
                // 如果前两大元素相等，则将最后一个元素放到第一位，并且堆大小-2
                stones[0] = stones[heapSize - 2];
                heapSize -= 2;
            }
            if (x != y) {
                // 如果前两大元素不等，第一个元素为两个元素的差值，并且堆大小-1
                stones[0] = x - y;
                heapSize -= 1;
            }
            // 重新调整堆
            adjust(stones, 0, heapSize);
        }
        return (heapSize == 0) ? 0 : stones[0];
    }

    /**
     * 1.建堆(最大堆)
     *
     * @param heap
     * @param heapSize
     */
    public void buildHeap(int[] heap, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            adjust(heap, i, heapSize);
        }
    }

    /**
     * 2.调整以i为根节点的堆
     *
     * @param heap
     * @param i
     * @param n
     */
    private void adjust(int[] heap, int i, int n) {
        // 因为是以数组为载体，所以左右两个子节点分别为+1，+2
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        // 最大值位置
        int max = i;
        if (left < n && heap[max] < heap[left]) {
            max = left;
        }
        if (right < n && heap[max] < heap[right]) {
            max = right;
        }
        // 当前节点小于其子节点的值
        if (max != i) {
            // 调整最大值为当前根节点的堆顶元素
            swap(heap, i, max);
            // 继续向下调整堆
            adjust(heap, max, n);
        }
    }

    /**
     * 交换两个值
     *
     * @param x
     * @param y
     */
    private void swap(int[] heap, int x, int y) {
        int tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

    /**
     * 递归方法，思路很巧妙
     * 将需要丢弃的石头重量置为0，或者为二者的差值
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight2(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        // 返回第一个元素减去第二个元素的绝对值
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        // 升序排列，最后一位元素为最大值
        Arrays.sort(stones);
        if (stones[stones.length - 3] == 0) {
            // 当只剩余两个元素非0时
            return Math.abs(stones[stones.length - 1] - stones[stones.length - 2]);
        }
        stones[stones.length - 2] = stones[stones.length - 1] - stones[stones.length - 2];
        // 第二大的元素置为0
        stones[stones.length - 2] = 0;
        return lastStoneWeight(stones);
    }

    /**
     * 使用api类，优先级队列
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight3(int[] stones) {
        // 优先级队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int i : stones) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            // x>=y
            int x = queue.poll();
            int y = queue.poll();
            if (x != y) {
                queue.offer(x - y);
            }
        }
        return (queue.size() == 0) ? 0 : queue.poll();
    }
}
