package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2023/02/01
 * 31. 下一个排列
 */
public class $31_nextPermutation {

    public static void main(String[] args) {
        $31_nextPermutation demo = new $31_nextPermutation();
        int[] nums = {3, 2, 1};
        demo.nextPermutation(nums);
    }

    /*
     * 1.从右侧向左侧寻找，遇到第一个升序对 i,j
     * 2.从右侧向左寻找第一个大于nums[i]的元素 k, 寻找范围 [j, nums.length-1]
     * 3.交换 nums[i] 和 nums[k]
     * 4.翻转 [j, nums.lent-1]的数据
     */

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // step 1
        int i = nums.length - 2, j = nums.length - 1;
        while (i >= 0) {
            if (nums[i] < nums[j]) {
                break;
            }
            i--;
            j--;
        }
        // 当前序列为递减序列 返回最小值
        if (i < 0) {
            convert(nums, 0, nums.length - 1);
            return;
        }

        // step 2
        int k;
        for (k = nums.length - 1; k >= j; k--) {
            if (nums[k] > nums[i]) {
                break;
            }
        }

        // step 3
        swap(nums, i, k);

        // step 4
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
