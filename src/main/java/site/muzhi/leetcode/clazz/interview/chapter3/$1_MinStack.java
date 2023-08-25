package site.muzhi.leetcode.clazz.interview.chapter3;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/04/13
 * @description 最小栈
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xa7r55/
 */
public class $1_MinStack {
    class MinStack {

        Stack<Integer> data;
        Stack<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack();
            min = new Stack();
        }

        public void push(int val) {
            data.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                Integer curMin = min.peek();
                min.push(curMin < val ? curMin : val);
            }
        }

        public void pop() {
            min.pop();
            data.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

}
