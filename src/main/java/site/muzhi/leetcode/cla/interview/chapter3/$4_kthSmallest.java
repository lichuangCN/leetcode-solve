package site.muzhi.leetcode.cla.interview.chapter3;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2021/04/14
 * @description 有序矩阵中第K小的元素
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xaicbc/
 */
public class $4_kthSmallest {

    /**
     * 小顶堆
     *
     * @param matrix
     * @param k      构建小顶堆，以左侧第一列初始化堆，依次向堆中添加元素，并且在弹出k-1个元素后，堆顶元素是第k小的元素
     * @return
     */
    public int kthSmallest_2(int[][] matrix, int k) {
        // int[]{当前元素值，元素所在行索引，元素所在列索引}
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] a1, int[] a2) -> a1[0] - a2[0]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            heap.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] curr = heap.poll();
            if (curr[2] != n - 1) {
                heap.offer(new int[]{matrix[curr[1]][curr[2] + 1], curr[1], curr[2] + 1});
            }
        }
        return heap.peek()[0];
    }

    /**
     * 暴力,思路
     * 时间复杂度O(n*n)
     * 大顶堆：存储前k小的元素，堆顶是前k个最小的元素中最大的一个，即第k小的元素
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest_1(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                heap.offer(row[j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}
