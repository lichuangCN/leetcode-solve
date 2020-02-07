package site.muzhi.solve;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。 pop() -- 删除栈顶的元素。 top() -- 获取栈顶元素。
 * getMin() --检索栈中的最小元素。
 *
 * @author lichuang
 * @date 2020/02/07
 */
public class MinStack155 {

    public static void main(String[] args) {
    }

}

class MinStack {

    /**
     * 存放数据
     */
    private Stack<Integer> dataStack;
    /**
     * 存放最小值
     */
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        dataStack.push(x);
        // 每次入栈需要比较，每次存放数据栈中元素最小值
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            // 如果新数据大于当前最小值
            if (minStack.peek() <= x) {
                x = minStack.peek();
            }
            minStack.push(x);
        }
    }

    public void pop() {
        // 数据栈和最小值栈同时弹出
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
