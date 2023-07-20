package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/20
 * 31.下一个排列
 */
public class $31_nextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2, j = nums.length - 1;
        while (i >= 0) {
            if (nums[i] < nums[j]) {
                break;
            }
            i--;
            j--;
        }

        if (i < 0) {
            convert(nums, 0, nums.length - 1);
            return;
        }

        int k = nums.length - 1;
        while (k >= j) {
            if (nums[k] > nums[i]) {
                break;
            }
            k--;
        }

        swap(nums, i, k);

        // 保证右侧 [j,nums.length-1] 是单调递减的
        convert(nums, j, nums.length - 1);
    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    private void convert(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
