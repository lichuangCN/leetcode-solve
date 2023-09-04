package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/04/06
 * @description 80. 删除有序数组中的重复项 II
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class $80_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (slow < 2 || nums[slow - 2] != nums[i]) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

}
