package site.muzhi.codetop.microsoft;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2022/12/07
 * @description 155. 最小栈
 */
public class $155_minStack {

    class MinStack {

        Stack<Integer> dataStack;
        Stack<Integer> minStack;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            dataStack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                Integer top = minStack.peek();
                minStack.push(top > val ? val : top);
            }
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
