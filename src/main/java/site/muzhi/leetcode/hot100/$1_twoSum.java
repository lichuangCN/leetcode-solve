package site.muzhi.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2021/04/01
 * @description 两数之和
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 */
public class $1_twoSum {

    /**
     * 通过补数的方式
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> t = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (t.containsKey(target - nums[i])) {
                int[] res = new int[2];
                res[0] = t.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            t.put(nums[i], i);
        }
        return null;
    }
}
