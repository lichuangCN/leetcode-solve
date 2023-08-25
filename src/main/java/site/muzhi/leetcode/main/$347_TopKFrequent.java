package site.muzhi.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2020/09/07
 * @description 前 K 个高频元素
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class $347_TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer val = map.get(num);
            if (val != null) {
                map.put(num, val + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 最小堆，堆大小为k
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x, y) -> x.getValue() - y.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            res[i] = entry.getKey();
        }
        return res;
    }

}
