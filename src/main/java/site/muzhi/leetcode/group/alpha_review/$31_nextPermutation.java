package site.muzhi.leetcode.group.alpha_review;

/**
 * @author lichuang
 * @date 2023/11/27
 */
public class $31_nextPermutation {

    public void nextPermutation(int[] nums) {
        int len = nums.length, i = len - 2, j = len - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        if (i < 0) {
            for (i = 0, j = len - 1; i <= j; i++, j--) {
                swap(nums, i, j);
            }
            return;
        }
        int k = len - 1;
        while (k >= j && nums[k] <= nums[i]) {
            k--;
        }
        swap(nums, i, k);
        for (int m = j, n = len - 1; m <= n; m++, n--) {
            swap(nums, m, n);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
