package site.muzhi.binarysearch;

/**
 * @author lichuang
 * @date 2021/04/09
 * @description 154. 寻找旋转排序数组中的最小值 II
 * <p>
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class $154_FindMin {

    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (0 < right && nums[right] == nums[0]) {
            right--;
        }

        // 序列递增
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[0] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
