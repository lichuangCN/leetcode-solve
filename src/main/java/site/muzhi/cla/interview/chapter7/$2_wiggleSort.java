package site.muzhi.cla.interview.chapter7;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2021/05/08
 * @description 摆动排序 II
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xaygd7/
 */
public class $2_wiggleSort {

    public void wiggleSort(int[] nums) {
        int[] help = nums.clone();
        Arrays.sort(help);
        int idx = nums.length;
        // 逆序穿插
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = help[--idx];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = help[--idx];
        }
    }
}
