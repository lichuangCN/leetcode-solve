package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/02
 * 34.在排序数组中查找元素的第一个和最后一个位置
 */
public class $34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
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
        for (right = mid; right < nums.length && nums[right] == target; right++) ;
        ans[1] = right - 1;
        return ans;
    }
}
