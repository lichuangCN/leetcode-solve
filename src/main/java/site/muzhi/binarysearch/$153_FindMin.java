package site.muzhi.binarysearch;

/**
 * @author lichuang
 * @date 2021/04/08
 * @description 153. 寻找旋转排序数组中的最小值
 * <p>
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class $153_FindMin {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // 序列递增
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        // 交叉
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}