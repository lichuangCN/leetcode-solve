package site.muzhi.leetcode.group.tencent50;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/11/08
 * 155.最小栈
 */
public class $155_MinStack {

    class MinStack {
        Stack<Integer> data;
        Stack<Integer> min;

        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                min.push(min.peek() < val ? min.peek() : val);
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
