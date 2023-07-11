package site.muzhi.codetop.frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/07/11
 * 1.两数之和
 */
public class $1_twoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (idxMap.containsKey(target - nums[i])) {
                return new int[]{i, idxMap.get(target - nums[i])};
            } else {
                idxMap.put(nums[i], i);
            }
        }
        return null;
    }
}
