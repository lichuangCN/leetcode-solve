package site.muzhi.leetcode.array;

/**
 * @author: LiChuang
 * @date: 2020/02/28
 * @description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class $34_FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * 采用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }
        // 第一次二分查找，寻找最左侧边界
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                // 当发现目标元素时，保存目标元素的下标
                result[0] = middle;
                // 继续二分查找左侧部分，
                right = middle - 1;
                continue;
            }
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // 第二次二分查找，寻找最右侧边界
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                result[1] = middle;
                left = middle + 1;
                continue;
            }
            if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }
}
