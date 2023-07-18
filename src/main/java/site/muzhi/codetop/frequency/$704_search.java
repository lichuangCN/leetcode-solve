package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/18
 * 704.二分查找
 */
public class $704_search {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
