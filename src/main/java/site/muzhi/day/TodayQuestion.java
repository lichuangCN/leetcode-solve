package site.muzhi.day;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2020/09/19
 * @description 出现已经做过的题目时，在此类中完成此题的代码的编写
 */
public class TodayQuestion {
    class MyQueue {

        Stack<Integer> inStack;
        Stack<Integer> outStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!outStack.isEmpty()) {
                return outStack.pop();
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!outStack.isEmpty()) {
                return outStack.peek();
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

}
