package site.muzhi.leetcode.binarysearch;

/**
 * @author lichuang
 * @date 2021/04/07
 * @description 81. 搜索旋转排序数组 II
 * <p>
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */
public class $81_Search {

    /**
     * 二分
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (right > left && nums[0] == nums[right]) {
            right--;
        }
        // 第一次二分,寻找分界点
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] >= nums[0]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return find(nums, 0, left - 1, target) || find(nums, left, nums.length - 1, target);
    }

    private boolean find(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 正反两个方向遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search_1(int[] nums, int target) {
        if (nums[0] == target) {
            return true;
        }
        if (nums[0] > target) {
            // 从后向前遍历
            int idx = nums.length - 1;
            while (idx >= 0) {
                if (nums[idx] == target) {
                    return true;
                }
                // 到达中间点
                if (idx == 0 || nums[idx - 1] > nums[idx]) {
                    return false;
                }
                idx--;
            }
        } else {
            // 从前向后遍历
            int idx = 0;
            while (idx < nums.length) {
                if (nums[idx] == target) {
                    return true;
                }
                // 到达中间点
                if (idx == nums.length - 1 || nums[idx + 1] < nums[idx]) {
                    return false;
                }
                idx++;
            }
        }
        return false;
    }
}
