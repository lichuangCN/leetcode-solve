package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/02/05
 * 26.删除有序数组中的重复项
 */
public class $26_removeDuplicates {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                i = i + 1;
            }
        }
        return i + 1;
    }
}
