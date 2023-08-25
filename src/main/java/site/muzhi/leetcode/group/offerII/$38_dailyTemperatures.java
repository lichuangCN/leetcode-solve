package site.muzhi.leetcode.group.offerII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/05/05
 * 38.每日温度
 */
public class $38_dailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return temperatures;
        }
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 栈记录最高温度
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                Integer idx = stack.pollLast();
                ans[idx] = i - idx;
            }
            stack.addLast(i);
        }
        return ans;
    }
}
