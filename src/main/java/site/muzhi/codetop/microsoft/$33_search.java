package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/15
 * 33.搜索旋转排序数组
 * 思想：有序数组，使用二分查找
 */
public class $33_search {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // [1,2,3,4,5,6]
        // [4,5,6,1,2,3]
        // 2
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                // 左侧区间递减
                if (nums[left] <= target && target < nums[mid]) {
                    // 左侧区间
                    right = mid - 1;
                } else {
                    // 右侧区间
                    left = mid + 1;
                }
            } else {
                // 右侧区间递增
                if (nums[mid] < target && target <= nums[right]) {
                    // 右侧区间
                    left = mid + 1;
                } else {
                    // 左侧区间
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
