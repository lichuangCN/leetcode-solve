package site.muzhi.leetcode.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2020/11/10
 * @description 最接近原点的 K 个点
 */
public class $973_KClosest {

    /**
     * 排序
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return (x[0] * x[0] + x[1] * x[1]) - (y[0] * y[0] + y[1] * y[1]);
            }
        });
        return Arrays.copyOf(points, K);
    }

    /**
     * 堆
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        // int[][] [0]点到原点的值，[1]points中的索引
        // 最大堆
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return y[0] - x[0];
            }
        });
        // 提前放入K个元素
        for (int i = 0; i < K; i++) {
            heap.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        // 遍历后续元素
        for (int i = K; i < points.length; i++) {
            int target = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (target < heap.peek()[0]) {
                // 此元素距离更近
                heap.poll();
                heap.offer(new int[]{target, i});
            }
        }
        // 获取堆中K个值
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[heap.poll()[1]];
        }
        return res;
    }
}
