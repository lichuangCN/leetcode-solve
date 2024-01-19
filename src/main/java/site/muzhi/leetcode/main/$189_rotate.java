package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/19
 * 189.轮转数组
 */
public class $189_rotate {

    public void rotate(int[] nums, int k) {
        int len = nums.length, mv = k % len;
        if (mv == 0) {
            return;
        }
        /*
         * 通过两次翻转，来修改元素的位置
         * nums = [1,2,3,4,5,6,7], k = 3
         *     [1,2,3,4,   5,6,7]
         * s1: [7,6,5,   4,3,2,1] 整体翻转
         * s2: [5,6,7,   1,2,3,4] 区间翻转
         */
        reverse(nums, 0, len - 1);
        reverse(nums, 0, mv - 1);
        reverse(nums, mv, len - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}
