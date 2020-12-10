package site.muzhi.offer;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2020/12/09
 * @description
 */
public class $30_MinStack {
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
            if (minStack.empty()) {
                minStack.push(x);
            } else {
                if (minStack.peek() < x) {
                    minStack.push(minStack.peek());
                } else {
                    minStack.push(x);
                }
            }
            dataStack.push(x);
        }

        public void pop() {
            minStack.pop();
            dataStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            if (minStack.empty()) {
                return 0;
            }
            return minStack.peek();
        }
    }

}
