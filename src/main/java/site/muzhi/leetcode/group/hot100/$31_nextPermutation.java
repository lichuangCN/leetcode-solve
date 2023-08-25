package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/23
 * 31.下一个排列
 */
public class $31_nextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 1.寻找第一个紧邻的递增序列对
        int i = nums.length - 1, j = nums.length - 2;
        while (j >= 0) {
            if (nums[i] > nums[j]) {
                break;
            }
            i--;
            j--;
        }

        if (j < 0) {
            // 递减排列 返回递增序列
            for (int m = 0, n = nums.length - 1; m < n; m++, n--) {
                swap(nums, m, n);
            }
            return;
        }

        // [i, nums.length-1]区间递减
        // 2.在 [i, nums.length-1] 中寻找第一个大于 nums[j]的元素
        int k = nums.length - 1;
        while (k > i) {
            if (nums[k] > nums[j]) {
                break;
            }
            k--;
        }

        // 3.交换 k j
        swap(nums, k, j);

        // 4.[i, nums.length-1] 当前是递减序列，调整为递增序列
        for (int m = i, n = nums.length - 1; m < n; m++, n--) {
            swap(nums, m, n);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
