package site.muzhi.offer;

/**
 * @author lichuang
 * @date 2020/10/16
 * @description 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class $21_Exchange {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 奇数
            while ((nums[left] & 1) == 1 && left < right) {
                left++;
            }
            // 偶数
            while ((nums[right] & 1) == 0 && left < right) {
                right--;
            }
            // 此时left只想偶数，right指向奇数，交换位置
            swap(left, right, nums);
        }
        return nums;
    }

    private void swap(int x, int y, int[] nums) {
        int num = nums[x];
        nums[x] = nums[y];
        nums[y] = num;
    }

}
