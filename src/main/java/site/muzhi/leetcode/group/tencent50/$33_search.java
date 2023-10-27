package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/27
 * 33.搜索旋转排序数组
 */
public class $33_search {

    // 4,5,6,7,8,9,1,2,3
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
