package site.muzhi.itbook.bk_1.chapter_1;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2022/10/30
 * @description leetcode: https://leetcode.cn/problems/min-stack/
 * 思路：
 * 1.每次push时，都对minStack入栈操作
 * 2.每次pop时，同步对minStack出栈操作
 *
 * 3.耗空间，出栈省时间
 */
public class Q1_1 {

    class MinStack {

        Stack<Integer> dataStack;
        Stack<Integer> minStack;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                int min = minStack.peek() > val ? val : minStack.peek();
                minStack.push(min);
            }
            dataStack.push(val);
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
