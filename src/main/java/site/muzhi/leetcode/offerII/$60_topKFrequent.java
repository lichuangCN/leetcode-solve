package site.muzhi.leetcode.offerII;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/05/24
 * 60.出现频率最高的k个数字
 */
public class $60_topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            int[] curr = numCount.containsKey(num) ? new int[]{num, numCount.get(num) + 1} : new int[]{num, 1};
            numCount.put(num, curr[1]);
            queue.offer(curr);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
