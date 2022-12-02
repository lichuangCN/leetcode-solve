package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/02
 * @description 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class $34_searchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return ans;
        }
        int len = nums.length;
        // 二分 找到目标值的位置
        int left = 0, right = len - 1, mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 未找到目标值
        if (left > right) {
            return ans;
        }

        // 向左遍历寻找左边界
        left = mid;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        ans[0] = left < 0 ? 0 : left + 1;

        // 向右遍历寻找右边界
        right = mid;
        while (right < len && nums[right] == target) {
            right++;
        }
        ans[1] = right == len ? len : right - 1;
        return ans;
    }
}
