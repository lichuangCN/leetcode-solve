package site.muzhi.leetcode.offer;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2020/11/03
 * @description 用两个栈实现队列
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
}
