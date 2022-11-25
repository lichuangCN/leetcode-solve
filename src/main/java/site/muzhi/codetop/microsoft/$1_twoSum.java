package site.muzhi.codetop.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2022/11/25
 * @description
 */
public class $1_twoSum {

    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        // <num,idx>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                ans = new int[]{map.get(target - num), i};
                return ans;
            }
            map.put(num, i);
        }
        return ans;
    }
}
