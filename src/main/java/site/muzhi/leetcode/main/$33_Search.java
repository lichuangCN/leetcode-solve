package site.muzhi.leetcode.main;

/**
 * @author: LiChuang
 * @date: 2020/02/28
 * @description: 33. 搜索旋转排序数组
 * <p>
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * <p>
 * 思想：
 * 前半部分有序。因此如果 nums[left] <= target < nums[middle]，则在前半部分找，否则去后半部分找。
 * 后半部分有序。因此如果 nums[middle] < target <= nums[right]，则在后半部分找，否则去前半部分找。
 */
public class $33_Search {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            // 此时区间的左侧区间为单调递增区间
            if (nums[left] <= nums[middle]) {
                if (nums[left] <= target && target < nums[middle]) {
                    // 此时目标值在左侧
                    right = middle - 1;
                } else {
                    // 此时目标值在右侧
                    left = middle + 1;
                }
            } else {
                // 如果区间的左侧区间非单调递增，则右侧区间必定单调增
                if (nums[middle] < target && target <= nums[right]) {
                    // 目标值在右侧
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
