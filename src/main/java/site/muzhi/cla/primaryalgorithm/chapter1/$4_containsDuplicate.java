package site.muzhi.cla.primaryalgorithm.chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 存在重复元素
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 */
public class $4_containsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
