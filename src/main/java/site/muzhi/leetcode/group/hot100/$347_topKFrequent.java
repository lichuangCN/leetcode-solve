package site.muzhi.leetcode.group.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/10/08
 * 347.前K个高频元素
 */
public class $347_topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> countQueue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            countQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = countQueue.poll()[0];
        }
        return ans;
    }
}
