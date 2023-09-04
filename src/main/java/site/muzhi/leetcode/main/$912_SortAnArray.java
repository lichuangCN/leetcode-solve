package site.muzhi.leetcode.main;

/**
 * @author: lichuang
 * @date: 2020/03/31
 * @description: 今日题目：数组排序。sort目录下，多种排序方式。
 */

public class $912_SortAnArray {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        int low = left, high = right;
        if (low >= high) {
            return;
        }
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low++] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        quickSort(nums, left, low - 1);
        quickSort(nums, low + 1, right);
    }
}
