package site.muzhi.leetcode.group.offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lichuang
 * @date 2020/11/03
 * @description 剑指 Offer 09. 用两个栈实现队列
 * <p>
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class $9_CQueue {
    class CQueue {
        private LinkedList<Integer> inStack;
        private LinkedList<Integer> outStack;

        public CQueue() {
            inStack = new LinkedList<>();
            outStack = new LinkedList<>();
        }

        public void appendTail(int value) {
            inStack.addLast(value);
        }

        public int deleteHead() {
            if (outStack.size() == 0) {
                // 栈内无元素
                int inSize = inStack.size();
                if (inSize == 0) {
                    return -1;
                }
                // 将进栈中的元素移动到出栈
                while (inSize > 0) {
                    outStack.addLast(inStack.pollLast());
                    inSize--;
                }
                return outStack.pollLast();
            }
            return outStack.pollLast();
        }
    }

    /**
     * 通过栈实现
     */
    class CQueue2 {

        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public CQueue2() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (!outStack.isEmpty()) {
                return outStack.pop();
            } else {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            if (outStack.isEmpty()) {
                return -1;
            }
            return outStack.pop();
        }
    }
}
