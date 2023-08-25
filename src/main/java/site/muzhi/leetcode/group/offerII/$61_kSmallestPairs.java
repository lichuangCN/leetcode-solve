package site.muzhi.leetcode.group.offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/05/24
 * 61.和最小的k个数对
 */
public class $61_kSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = Math.min(nums1.length, k);
        int len2 = Math.min(nums2.length, k);
        // 大根堆
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> y[0] + y[1] - x[0] - x[1]);
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                heap.offer(new int[]{nums1[i], nums2[j]});
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] ints : heap) {
            ans.add(Arrays.asList(ints[0], ints[1]));
        }
        return ans;
    }
}
