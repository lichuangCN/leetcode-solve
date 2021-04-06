package site.muzhi.array;

/**
 * @author lichuang
 * @date 2021/04/06
 * @description 26. 删除有序数组中的重复项
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class $26_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx < 1 || nums[idx - 1] != nums[i]) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}
