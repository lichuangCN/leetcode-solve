package site.muzhi.leetcode.group.offerII;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lichuang
 * @date 2023/05/24
 * 60.出现频率最高的k个数字
 */
public class $60_topKFrequent {

    public static void main(String[] args) {
        $60_topKFrequent k = new $60_topKFrequent();
        int[] ints = k.topKFrequent(new int[]{5, 3, 1, 1, 1, 3, 73, 1}, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
            int[] curr = new int[]{entry.getKey(), entry.getValue()};
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
