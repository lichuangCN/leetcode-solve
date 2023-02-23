package site.muzhi.leetcode.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/02/23
 */
public class $10_subarraySum {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        int ans = 0, presum = 0;
        for (int num : nums) {
            presum += num;
            if (prefixMap.containsKey(presum - k)) {
                ans += prefixMap.get(presum - k);
            }
            prefixMap.put(presum, prefixMap.getOrDefault(presum, 0) + 1);
        }
        return ans;
    }
}
