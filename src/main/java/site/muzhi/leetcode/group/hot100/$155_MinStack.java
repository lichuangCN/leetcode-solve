package site.muzhi.leetcode.group.hot100;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/09/12
 * 155.最小栈
 */
public class $155_MinStack {
    class MinStack {

        Stack<Integer> data, min;

        public MinStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                val = val > min.peek() ? min.peek() : val;
                min.push(val);
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
