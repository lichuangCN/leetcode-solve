package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2024/01/23
 * 55.跳跃游戏
 */
public class $55_canJump {

    public boolean canJump(int[] nums) {
        int skip = 0;
        for (int i = 0; i <= skip; i++) {
            skip = Math.max(skip, i + nums[i]);
            if (skip >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
