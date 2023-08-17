package site.muzhi.codetop.frequency;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/08/17
 * 283.移动零
 */
public class $283_moveZeroes {

    public void moveZeroes(int[] nums) {

        int idx = 0, len = nums.length;

        // 将非0元素向前移动
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        // 处理后面 0
        Arrays.fill(nums, idx, len, 0);
    }
}
