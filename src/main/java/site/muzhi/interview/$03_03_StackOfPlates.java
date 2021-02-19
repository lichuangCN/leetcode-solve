package site.muzhi.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/02/19
 * @description 堆盘子
 */
public class $03_03_StackOfPlates {
    class StackOfPlates {

        // 栈索引
        int stackIdx;
        int stackSize;
        List<Stack<Integer>> stackList;

        public StackOfPlates(int cap) {
            stackIdx = -1;
            stackSize = cap;
            stackList = new ArrayList<>();
        }

        public void push(int val) {
            // 容量可能小于等于0
            if (stackSize <= 0) {
                return;
            }
            if (stackIdx == -1) {
                Stack<Integer> newStack = new Stack<>();
                newStack.push(val);
                stackList.add(newStack);
                stackIdx++;
                return;
            }
            Stack<Integer> stack = stackList.get(stackIdx);
            if (stack.size() < stackSize) {
                stack.add(val);
            } else {
                Stack<Integer> newStack = new Stack<>();
                newStack.push(val);
                stackList.add(newStack);
                stackIdx++;
            }
        }

        public int pop() {
            if (stackIdx == -1) {
                return -1;
            }
            Stack<Integer> stack = stackList.get(stackIdx);
            Integer val = stack.pop();
            if (stack.isEmpty()) {
                stackList.remove(stackIdx);
                stackIdx--;
            }
            return val;
        }

        public int popAt(int index) {
            if (index > stackIdx) {
                return -1;
            }
            Stack<Integer> stack = stackList.get(index);
            Integer val = stack.pop();
            if (stack.isEmpty()) {
                stackList.remove(index);
                stackIdx--;
            }
            return val;
        }
    }
}
