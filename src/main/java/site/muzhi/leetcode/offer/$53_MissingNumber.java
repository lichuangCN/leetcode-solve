package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/10/19
 * @description 0～n-1中缺失的数字
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class $53_MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] != mid) {
                // nums[mid]值不等于mid时，表明在mid前已经出现了错位
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length - 1 && nums[left] == left) {
            // 缺的是n
            return nums.length;
        } else {
            return left;
        }
    }
}
