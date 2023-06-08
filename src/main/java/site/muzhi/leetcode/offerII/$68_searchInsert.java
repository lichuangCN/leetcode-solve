package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/06/07
 */
public class $68_searchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 判断位置 mid 当前位置 或者后一位
        if (nums[mid] < target) {
            return mid + 1;
        } else {
            return mid;
        }


    }
}
