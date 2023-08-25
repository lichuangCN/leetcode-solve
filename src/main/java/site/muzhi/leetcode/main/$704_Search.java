package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/12/08
 * @description 704. 二分查找
 * <p>
 * https://leetcode-cn.com/problems/binary-search/
 */
public class $704_Search {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return -1;
        }
        int left = 0, right = nums.length - 1, mid = (left + right) / 2;
        while (left <= right) {
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }
}
