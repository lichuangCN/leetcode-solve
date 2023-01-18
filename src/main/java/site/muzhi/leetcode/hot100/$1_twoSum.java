package site.muzhi.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2023/01/18
 * 1.两数之和
 */
public class $1_twoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] ans = new int[2];
        // key nums元素
        // value nums元素的索引
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(target - nums[i])) {
                ans[0] = dict.get(target - nums[i]);
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}
