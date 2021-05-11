package site.muzhi.cla.primaryalgorithm.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/05/11
 * @description 旋转数组
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 */
public class $3_rotate {

    /**
     * 原地旋转
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // 实际移动的元素个数
        k = k % len;
        // 1.全局翻转
        rotate(nums, 0, len - 1);
        // 2.翻转前k个
        rotate(nums, 0, k - 1);
        // 3.翻转后len-k个
        rotate(nums, k, len - 1);
    }

    private void rotate(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }


    /**
     * 创建临时数组
     *
     * @param nums
     * @param k
     */
    public void rotate_2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        int[] help = nums.clone();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 元素移动后的新位置(i+k)%len
            nums[(i + k) % len] = help[i];
        }
    }

    public void rotate_1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        int len = nums.length;

        int move = k % len;
        if (move == 0) {
            return;
        }
        int idx = len - move;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            list.add(nums[i]);
        }

        // 移动后面的元素
        int cur = 0;
        while (idx < len) {
            nums[cur++] = nums[idx++];
        }
        for (int i = 0; i < list.size(); i++) {
            nums[cur++] = list.get(i);
        }
    }
}
