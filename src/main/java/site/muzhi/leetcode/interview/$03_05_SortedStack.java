package site.muzhi.leetcode.interview;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/02/19
 * @description
 */
public class $03_05_SortedStack {
    class SortedStack {

        Stack<Integer> dataStack;

        public SortedStack() {
            dataStack = new Stack<>();
        }

        public void push(int val) {
            if (dataStack.isEmpty() || dataStack.peek() >= val) {
                dataStack.push(val);
                return;
            }
            Stack<Integer> tempStack = new Stack<>();
            while (!dataStack.isEmpty() && dataStack.peek() < val) {
                tempStack.push(dataStack.pop());
            }
            dataStack.push(val);
            while (!tempStack.isEmpty()) {
                dataStack.push(tempStack.pop());
            }
        }

        public void pop() {
            if (!dataStack.isEmpty()) {
                dataStack.pop();
            }
        }

        public int peek() {
            if (dataStack.isEmpty()) {
                return -1;
            }
            return dataStack.peek();
        }

        public boolean isEmpty() {
            return dataStack.isEmpty();
        }
    }
}
