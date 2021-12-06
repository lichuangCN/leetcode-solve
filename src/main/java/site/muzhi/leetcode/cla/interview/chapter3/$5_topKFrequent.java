package site.muzhi.leetcode.cla.interview.chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2021/04/22
 * @description 前 K 个高频元素
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xau4ci/
 */
public class $5_topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((x, y) -> x.getValue() - y.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}
