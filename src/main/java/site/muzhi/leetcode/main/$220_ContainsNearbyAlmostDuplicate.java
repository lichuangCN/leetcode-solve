package site.muzhi.leetcode.array;

import java.util.TreeSet;

/**
 * @author lichuang
 * @date 2021/04/19
 * @description 220. 存在重复元素 III
 * <p>
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class $220_ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long u = nums[i] * 1L;
            // 比u小或等于u的最大值
            Long l = set.floor(u);
            // 比u大或等于u的最小值
            Long r = set.ceiling(u);
            if (l != null && u - l <= t) {
                return true;
            }
            if (r != null && r - u <= t) {
                return true;
            }
            set.add(u);
            if (i >= k) {
                set.remove(nums[i - k] * 1L);
            }
        }
        return false;
    }
}
