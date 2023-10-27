package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/27
 * 26.删除有序数组中的重复项
 */
public class $26_removeDuplicates {

    public int removeDuplicates(int[] nums) {
        int len = nums.length, left = 0, right = left + 1;
        while (right < len) {
            if (nums[right] == nums[left]) {
                right++;
                continue;
            }
            nums[++left] = nums[right];
        }
        return left + 1;
    }
}
