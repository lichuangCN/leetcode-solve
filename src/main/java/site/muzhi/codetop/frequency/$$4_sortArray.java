package site.muzhi.codetop.frequency;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/07/11
 */
public class $$4_sortArray {

    public static void main(String[] args) {
//        int[] array = {6, 1, 3, 6, 1, 8, 2, 4, 9, 5};
        int[] array = {};
        $$4_sortArray demo = new $$4_sortArray();
        demo.sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int left = low, right = high;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            // left == right || nums[right] < sentry
            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }
            // left == right || nums[left] > sentry
            nums[right] = nums[left];
        }
        // left == right
        nums[left] = pivot;
        sort(nums, low, left - 1);
        sort(nums, left + 1, high);
    }
}
