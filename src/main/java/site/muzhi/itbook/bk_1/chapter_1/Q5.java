package site.muzhi.itbook.bk_1.chapter_1;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2022/10/30
 * @description leetcode:https://leetcode.cn/problems/sort-of-stacks-lcci/
 * 栈排序，只允许开辟一个辅助空间
 */
public class Q5 {
    class SortedStack {

        Stack<Integer> helpStack;
        Stack<Integer> dataStack;

        public SortedStack() {
            helpStack = new Stack<>();
            dataStack = new Stack<>();
        }

        public void push(int val) {
            if (dataStack.isEmpty() || val <= dataStack.peek()) {
                dataStack.push(val);
            } else {
                while (!dataStack.isEmpty() && val > dataStack.peek()) {
                    helpStack.push(dataStack.pop());
                }
                dataStack.push(val);
                // 此操作后 helpStack已经是空栈
                while (!helpStack.isEmpty()) {
                    dataStack.push(helpStack.pop());
                }
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
