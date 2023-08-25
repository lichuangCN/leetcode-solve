package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/02/20
 */
public class $6_twoSum {

    public int[] towSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }

        }
        return ans;
    }
}
