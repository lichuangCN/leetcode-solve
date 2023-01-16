package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/13
 * 494 目标和
 */
public class $494_findTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return travel(nums, target, 0, 0);
    }

    private int travel(int[] nums, int target, int curr, int idx) {
        // 当前满足一种解
        if (idx == nums.length) {
            return target == curr ? 1 : 0;
        }
        int right = travel(nums, target, curr + nums[idx], idx + 1);
        int left = travel(nums, target, curr - nums[idx], idx + 1);
        return right + left;
    }
}
