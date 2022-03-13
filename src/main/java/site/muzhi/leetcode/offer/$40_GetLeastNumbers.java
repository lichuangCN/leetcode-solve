package site.muzhi.leetcode.offer;

import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2022/03/13
 * @description 剑指 Offer 40. 最小的k个数
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class $40_GetLeastNumbers {

    /**
     * 最大堆（堆顶元素为当前堆的最大值）
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        // 先填充k个值
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }
        // 处理arr.length - k
        for (int i = k; i < arr.length; i++) {
            if (maxHeap.peek() > arr[i]) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }
        return ans;
    }
}
