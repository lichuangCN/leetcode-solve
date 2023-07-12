package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/12
 * 3.搜索旋转排序数组
 */
public class $33_search {

    // 输入：nums = [4,5,6,7,0,1,2], target = 0
    // 输出：4

    // 输入：nums = [4,5,6,7,0,1,2], target = 3
    // 输出：-1
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }

            // nums[left] <= nums[mid]: [left, mid] 单调递减; 否则 [mid, right] 单调递增
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
