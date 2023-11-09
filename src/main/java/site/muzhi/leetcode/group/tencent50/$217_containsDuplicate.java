package site.muzhi.leetcode.group.tencent50;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lichuang
 * @date 2023/11/08
 * 217.存在重复元素
 */
public class $217_containsDuplicate {

    public boolean containsDuplicate(int[] nums) {
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
