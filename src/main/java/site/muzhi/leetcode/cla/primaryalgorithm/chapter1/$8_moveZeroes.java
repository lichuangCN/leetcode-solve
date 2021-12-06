package site.muzhi.leetcode.cla.primaryalgorithm.chapter1;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 移动零
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 */
public class $8_moveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n != 0) {
                nums[idx++] = n;
            }
        }
        // 置0
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
