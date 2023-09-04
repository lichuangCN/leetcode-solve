package site.muzhi.leetcode.main;

import java.util.Stack;

/**
 * @author: LiChuang
 * @date: 2020/03/01
 * @description: 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class $232_ImplementQueueUsingStacks {

    class MyQueue {

        /**
         * 添加元素时入的栈
         */
        Stack<Integer> inStack;
        /**
         * 移除元素时出的栈
         */
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
            } else {
                // 如果弹出元素的栈为空，则将压入元素栈中元素弹出并压入弹出元素栈
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
                if (!outStack.isEmpty()) {
                    return outStack.pop();
                } else {
                    throw new NullPointerException("队列为空");
                }
            }
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!outStack.isEmpty()) {
                return outStack.peek();
            }else {
                // 如果弹出元素的栈为空，则将压入元素栈中元素弹出并压入弹出元素栈
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
                if (!outStack.isEmpty()) {
                    return outStack.peek();
                } else {
                    throw new NullPointerException("队列为空");
                }
            }
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return (inStack.isEmpty() && outStack.isEmpty());
        }
    }
}
