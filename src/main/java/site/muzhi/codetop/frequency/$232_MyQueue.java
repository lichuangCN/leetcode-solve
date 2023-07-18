package site.muzhi.codetop.frequency;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/07/18
 * 232.用栈实现队列
 */
public class $232_MyQueue {

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
            return popStack.isEmpty() && pushStack.empty();
        }
    }

}


