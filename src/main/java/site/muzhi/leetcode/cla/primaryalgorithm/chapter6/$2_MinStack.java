package site.muzhi.leetcode.cla.primaryalgorithm.chapter6;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/05/22
 * @description 最小栈
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnkq37/
 */
public class $2_MinStack {

    class MinStack {

        Stack<Integer> dataStack;
        Stack<Integer> minStack;

        public MinStack() {
            dataStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int val) {
            dataStack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                Integer top = minStack.peek();
                if (val < top) {
                    minStack.push(val);
                } else {
                    minStack.push(top);
                }
            }
        }

        public void pop() {
            minStack.pop();
            dataStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
