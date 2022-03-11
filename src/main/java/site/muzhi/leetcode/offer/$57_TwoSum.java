package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/10/31
 * @description 剑指 Offer 57. 和为s的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class $57_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] resArr = new int[2];
        if (nums == null || nums.length == 0 || nums[0] >= target) {
            return resArr;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            }
            if (sum > target) {
                right--;
            }
            if (sum == target) {
                resArr[0] = nums[left];
                resArr[1] = nums[right];
                return resArr;
            }
        }
        return resArr;
    }
}
