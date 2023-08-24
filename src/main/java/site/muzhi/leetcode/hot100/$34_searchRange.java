package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2023/08/24
 * 34.排序数组中查找元素的第一个和最后一个位置
 */
public class $34_searchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int len = nums.length;
        if (nums[0] > target || nums[len - 1] < target) {
            return ans;
        }
        int left = 0, right = len - 1, mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left > right) {
            return ans;
        }
        for (left = mid; left >= 0 && nums[left] == target; left--) ;
        ans[0] = left + 1;
        for (right = mid; right < len && nums[right] == target; right++) ;
        ans[1] = right - 1;
        return ans;
    }
}
