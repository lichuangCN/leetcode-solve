package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2023/08/23
 * 33.搜索旋转排序数组
 */
public class $33_search {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // 左侧单增
                /* [3,4,5,6,1,2]
                 *          6
                 *       5[mid]
                 *    4
                 * 3
                 *             2
                 *          1
                 */
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右侧单增
                /* [5,6,1,2,3,4]
                 *    6
                 * 5
                 *                   4
                 *                3
                 *             2
                 *          1[mid]
                 */
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
