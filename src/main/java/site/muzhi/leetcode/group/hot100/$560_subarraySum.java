package site.muzhi.leetcode.group.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/10/12
 * 560.和为k的子数组
 */
public class $560_subarraySum {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);

        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += prefix.getOrDefault(sum - k, 0);

            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
