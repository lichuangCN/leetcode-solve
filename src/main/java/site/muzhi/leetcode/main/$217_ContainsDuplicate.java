package site.muzhi.leetcode.main;

import java.util.HashSet;

/**
 * @author: lichuang
 * @date: 2020/03/11
 * @description:
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。
 * 如果数组中每个元素都不相同，则返回 false。
 */

public class $217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        // 通过集合手段来判断当前元素是否与之前遍历的元素相同
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
