package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/04/08
 * @description 153. 寻找旋转排序数组中的最小值
 */
public class $153_FindMin {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}