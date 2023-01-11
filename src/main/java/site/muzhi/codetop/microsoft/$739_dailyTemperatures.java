package site.muzhi.codetop.microsoft;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2023/01/11
 * 739 每日温度
 */
public class $739_dailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int[] ans = new int[temperatures.length];
        // 存的索引 该栈是一个单调栈：栈顶元素（温度）到栈底元素依次递增
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 如果即将入栈的元素（温度）比栈顶元素高
            // 循环出栈直到栈元素为空 或 栈顶元素大于即将入站的元素
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                Integer idx = stack.pollLast();
                // 距离天数
                ans[idx] = i - idx;
            }
            // 入栈
            stack.addLast(i);
        }
        return ans;
    }
}
