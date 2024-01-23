package site.muzhi.codetop.frequency;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2024/01/22
 * offer 09 图书整理 II
 */
public class $offer_$09_CQueue {

    class CQueue {

        Stack<Integer> push;
        Stack<Integer> pop;

        public CQueue() {
            push = new Stack<>();
            pop = new Stack<>();
        }

        public void appendTail(int value) {
            push.push(value);
        }

        public int deleteHead() {
            if (push.isEmpty() && pop.isEmpty()) {
                return -1;
            }
            if (pop.isEmpty()) {
                while (!push.isEmpty()) {
                    pop.push(push.pop());
                }
                return pop.pop();
            } else {
                return pop.pop();
            }
        }
    }
}
