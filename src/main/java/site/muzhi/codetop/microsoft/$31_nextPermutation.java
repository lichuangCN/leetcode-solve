package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/12/06
 * @description 31. 下一个排列
 * <p>
 * 题解：https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 */
public class $31_nextPermutation {
    public void nextPermutation(int[] nums) {
        // 1.从后向前寻找第一个相邻的升序对 nums[i]<nums[j]
        int i = nums.length - 2, j = nums.length - 1;
        while (i >= 0) {
            if (nums[i] < nums[j]) {
                break;
            }
            i--;
            j--;
        }
        // 没有升序对，即全是降序 已经是最高值，翻转返回最小值
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // 2.在[j,nums.length-1]范围内寻找第一个k, 使得nums[i]<nums[k]
        int k;
        for (k = nums.length - 1; k >= j; k--) {
            if (nums[i] < nums[k]) {
                break;
            }
        }

        // 交换 nums[i] 和nums[k]
        swap(nums, i, k);

        // [j,nums.length-1]必定是降序
        reverse(nums, j, nums.length - 1);
        return;
    }

    private void swap(int[] nums, int m, int n) {
        int t = nums[m];
        nums[m] = nums[n];
        nums[n] = t;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
