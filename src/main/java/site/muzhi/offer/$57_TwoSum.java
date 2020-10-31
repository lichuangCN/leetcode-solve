package site.muzhi.offer;

/**
 * @author lichuang
 * @date 2020/10/31
 * @description 和为s的两个数字
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
