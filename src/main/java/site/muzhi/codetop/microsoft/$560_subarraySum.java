package site.muzhi.codetop.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2022/11/16
 * 前缀和
 */
public class $560_subarraySum {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 前缀和
        int count = 0, presum = 0;
        for (int num : nums) {
            presum += num;
            // 前缀和中，存在 有区间的和 = k
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);
            }
            // 相同前缀和统计
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
