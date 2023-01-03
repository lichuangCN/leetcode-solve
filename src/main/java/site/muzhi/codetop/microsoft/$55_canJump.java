package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/03
 * 55.跳跃游戏
 */
public class $55_canJump {

    public boolean canJump(int[] nums) {
        // cover: 最大能够跳跃的范围
        // 在最大能够跳跃范围内尽可能的向右侧寻找最大跳跃距离
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            // 刷新能到达的最远的距离
            cover = Math.max(nums[i] + i, cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
