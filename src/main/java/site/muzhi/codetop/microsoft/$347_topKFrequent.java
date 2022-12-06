package site.muzhi.codetop.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2022/12/06
 * @description 347. 前 K 个高频元素
 */
public class $347_topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        // 统计出现的次数
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }

        // 构建堆 大顶堆
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            heap.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // 依次取出出现频率高的元素
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll()[0];
        }
        return ans;
    }
}
