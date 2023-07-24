package site.muzhi.codetop.frequency;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/07/24
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
            if (min.isEmpty() || val < min.peek()) {
                min.push(val);
            } else {
                min.push(min.peek());
            }
        }

        public void pop() {
            min.pop();
            data.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
