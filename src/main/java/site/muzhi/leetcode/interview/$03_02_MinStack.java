package site.muzhi.leetcode.interview;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/02/19
 * @description 栈的最小值
 */
public class $03_02_MinStack {
    class MinStack {

        Stack<Integer> dataStack;
        Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            Integer val = dataStack.pop();
            if (minStack.peek() >= val) {
                minStack.pop();
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
