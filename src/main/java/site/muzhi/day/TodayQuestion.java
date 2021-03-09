package site.muzhi.day;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lichuang
 * @date 2020/09/19
 * @description 出现已经做过的题目时，在此类中完成此题的代码的编写
 */
public class TodayQuestion {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }

}
