package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/09/27
 * 283.移动零
 */
public class $283_moveZeroes {

    public void moveZeroes(int[] nums) {
        int idx = 0, ptr = 0, len = nums.length;
        while (ptr < len) {
            if (nums[ptr] != 0) {
                nums[idx++] = nums[ptr];
            }
            ptr++;
        }

        for (int i = idx; i < len; i++) {
            nums[i] = 0;
        }
    }
}
