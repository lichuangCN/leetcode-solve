package site.muzhi.itbook.bk_1.chapter_1;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2022/10/30
 * @description leetcode: https://leetcode.cn/problems/implement-queue-using-stacks/
 *
 * 思路：
 * 1.出队列时 popStack 如果有元素则必须使用popStack栈中元素出栈
 * 2.出队列时 popStack 如果有没有素，则需要将pushStack栈中元素全部移动到popStack中后，再出栈
 */
public class Q2 {

    class MyQueue {

        Stack<Integer> pushStack;
        Stack<Integer> popStack;

        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public void push(int x) {
            pushStack.push(x);
        }

        public int pop() {
            if (!popStack.isEmpty()) {
                return popStack.pop();
            }

            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.pop();
        }

        public int peek() {
            if (!popStack.isEmpty()) {
                return popStack.peek();
            }

            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.peek();
        }

        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }
}
