package site.muzhi.array;

/**
 * @author: LiChuang
 * @date: 2020/02/24
 * @description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度，
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 */
public class $55_JumpGame1 {

    public boolean canJump(int[] nums) {
        // 每个位置最远可跳位置
        int[] indexNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexNums[i] = nums[i] + i;
        }
        // 当前跳到的位置
        int jump = 0;
        // 最远跳跃的位置
        int maxIndex = indexNums[0];
        // 遍历最远可跳位置数组,jump是否超过最远的跳跃位置
        while (jump < indexNums.length && jump < maxIndex) {
            // 结束条件：1.数组遍历完毕；2.无法到达数组最后一位
            if (maxIndex < indexNums[jump]) {
                maxIndex = indexNums[jump];
            }
            jump++;
        }
        // 如果到达数组尾部
        if (jump==indexNums.length) {
            return true;
        }
        return false;
    }
}
