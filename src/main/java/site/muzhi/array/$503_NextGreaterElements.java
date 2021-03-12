package site.muzhi.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/03/08
 * @description
 */
public class $503_NextGreaterElements {

    /**
     * 暴力
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int idx = i + 1;
            while (idx < len + i) {
                if (nums[idx % len] > nums[i]) {
                    res[i] = nums[idx % len];
                    break;
                }
                idx++;
            }
            if (idx == len + i) {
                res[i] = -1;
            }
        }

        return res;
    }

    /**
     * 单调栈
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements_2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }

        return res;
    }
}
