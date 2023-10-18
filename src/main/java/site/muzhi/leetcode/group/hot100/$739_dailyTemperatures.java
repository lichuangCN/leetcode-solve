package site.muzhi.leetcode.group.hot100;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/10/13
 * 739.每日温度
 */
public class $739_dailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}
