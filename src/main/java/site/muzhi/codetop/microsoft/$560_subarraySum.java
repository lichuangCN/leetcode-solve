package site.muzhi.codetop.microsoft;

import java.util.HashMap;

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
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 前缀和
        int count = 0, presum = 0;
        for (int num : nums) {
            presum += num;
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);
            }
            map.put(presum, map.getOrDefault(presum - k, 0) + 1);
        }
        return count;
    }
}
