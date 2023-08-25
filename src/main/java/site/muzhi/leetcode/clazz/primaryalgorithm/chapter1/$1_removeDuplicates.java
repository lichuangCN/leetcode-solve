package site.muzhi.leetcode.clazz.primaryalgorithm.chapter1;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 删除排序数组中的重复项
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 */
public class $1_removeDuplicates {

    public int removeDuplicates(int[] nums) {

        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[idx]) {
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }
}
