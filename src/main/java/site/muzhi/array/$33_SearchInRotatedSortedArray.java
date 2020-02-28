package site.muzhi.array;

/**
 * @author: LiChuang
 * @date: 2020/02/28
 * @description:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 思想：
 * 前半部分有序。因此如果 nums[left] <= target < nums[middle]，则在前半部分找，否则去后半部分找。
 * 后半部分有序。因此如果 nums[middle] < target <= nums[right]，则在后半部分找，否则去前半部分找。
 */
public class $33_SearchInRotatedSortedArray {

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
