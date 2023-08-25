package site.muzhi.leetcode.array;

/**
 * @author lichuang
 * @date 2021/02/19
 * @description 最大连续 1 的个数
 */
public class $485_FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
