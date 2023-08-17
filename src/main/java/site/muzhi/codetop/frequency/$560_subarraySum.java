package site.muzhi.codetop.frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/08/17
 * 560.和为k的子数组
 */
public class $560_subarraySum {

    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, preSum = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
