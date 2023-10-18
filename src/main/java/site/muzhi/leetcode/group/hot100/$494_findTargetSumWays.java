package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/11
 * 494.目标和
 */
public class $494_findTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {

        return travel(nums, 0, 0, target);
    }

    private int travel(int[] nums, int idx, int sum, int target) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }
        int add = travel(nums, idx + 1, sum + nums[idx], target);
        int minus = travel(nums, idx + 1, sum - nums[idx], target);
        return add + minus;
    }
}
