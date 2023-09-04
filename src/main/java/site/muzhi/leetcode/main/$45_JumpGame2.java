package site.muzhi.leetcode.main;

/**
 * @author: LiChuang
 * @date: 2020/02/24
 * @description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 */
public class $45_JumpGame2 {

    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        // 当前最远的跳跃位置
        int currentMaxIndex = nums[0];
        // 遍历过程中，可到达的最远位置
        int preMaxMaxIndex = nums[0];
        // 最小跳跃次数
        int jumpTime = 1;
        for (int i = 0; i < nums.length; i++) {
            // 当无法在向前移动时，执行一次跳跃，计算从[i,currentMaxIndex]之间跳跃一次的最远距离
            if (i > currentMaxIndex) {
                jumpTime++;
                currentMaxIndex = preMaxMaxIndex;
            }
            if (preMaxMaxIndex < nums[i] + i) {
                /*
                 * 在遍历过程中发现更远值时，更新最远
                 * 在中间的遍历过程中寻找一次跳跃点
                 */
                preMaxMaxIndex = nums[i] + i;
            }
        }
        return jumpTime;
    }
}
