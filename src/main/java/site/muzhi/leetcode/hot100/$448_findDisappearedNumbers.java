package site.muzhi.leetcode.hot100;

import java.util.*;

/**
 * @author lichuang
 * @date 2022/12/01
 * @description 448. 找到所有数组中消失的数字
 */
public class $448_findDisappearedNumbers {

    /**
     * 哈希表
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * 原地修改数组
     */
    public List<Integer> findDisappearedNumbers_1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            // 因为当前 nums[i]可能已经被前面的给设置为 负数值
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        // 未被处理为负数，则表示此i+1数未存在
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

}
