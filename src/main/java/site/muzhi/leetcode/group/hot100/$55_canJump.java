package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/28
 * 55.跳跃游戏
 */
public class $55_canJump {

    public boolean canJump(int[] nums) {
        // 最远距离坐标
        int skip = 0;
        for (int i = 0; i <= skip; i++) {
            skip = Math.max(skip, nums[i] + i);
            if (skip >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
