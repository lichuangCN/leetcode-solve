package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/12
 * 581.最短无序连续子数组
 */
public class $581_findUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        // 递增序列
        int i = 0, j = nums.length - 1, len = nums.length;
        while (i < j && nums[i] <= nums[i + 1]) i++;
        while (i < j && nums[j] >= nums[j - 1]) j--;

        int min = nums[i], max = nums[j];
        int l = i, r = j;
        for (l = i; l <= r; l++) {
            // 向左向右寻找最小最大值
            if (nums[l] < min) {
                while (i >= 0 && nums[i] > nums[l]) i--;
                min = (i >= 0) ? nums[i] : Integer.MIN_VALUE;
            }
            if (nums[l] > max) {
                while (j <= len - 1 && nums[j] < nums[l]) j++;
                max = (j <= len - 1) ? nums[j] : Integer.MAX_VALUE;
            }
        }
        return i == j ? 0 : (j - 1) - (i + 1) + 1;
    }
}
