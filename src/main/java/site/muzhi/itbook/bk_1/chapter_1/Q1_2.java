package site.muzhi.itbook.bk_1.chapter_1;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2022/10/30
 * @description leetcode: https://leetcode.cn/problems/min-stack/
 * 思路：
 * 1.每次push时，先比较元素是否小于 minStack 栈顶元素；小于时才入栈
 * 2.每次pop时，比对dataStack要出栈元素是否等于 minStack 栈顶元素；相等时，minStack才出栈
 *
 * 3.节省空间，出栈费时间
 */
public class Q1_2 {

    class MinStack {

        Stack<Integer> dataStack;
        Stack<Integer> minStack;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            // here
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else if (val <= minStack.peek()) {
                minStack.push(val);
            }
            dataStack.push(val);
        }

        public void pop() {
            // here
            if (dataStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
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
