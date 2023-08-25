package site.muzhi.leetcode.group.offer;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2020/12/09
 * @description 剑指 Offer 30. 包含min函数的栈
 * <p>
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
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
            return minStack.peek();
        }
    }

}
