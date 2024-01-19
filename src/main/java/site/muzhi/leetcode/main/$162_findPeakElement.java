package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/19
 * 162.寻找峰值
 */
public class $162_findPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 边界值也可以成为峰值
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
