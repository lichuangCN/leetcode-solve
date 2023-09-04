package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2022/05/06
 * @description 167. 两数之和 II - 输入有序数组
 * <p>
 * <p>
 * 因为有序，所有可以使用双指针的方式去找
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class $167_TwoSum_2 {


    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length < 2) {
            return new int[]{-1, -1};
        }
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{++left, ++right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
