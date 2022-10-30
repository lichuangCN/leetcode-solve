package site.muzhi.itbook.bk_1.chapter_1;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2022/10/30
 * @description 栈元素翻转 （递归方式）
 * 思路：
 * 1.先递归获取（移除）当时栈底的最后一个元素，直到最后栈中元素全部移出；此时栈中元素已经根据递归层级翻转
 * 2.递归回溯进行入栈操作
 *
 * 示例:
 * ori  dest
 * 1    4
 * 2    3
 * 3    2
 * 4    1
 */
public class Q3_1 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        Q3_1 test = new Q3_1();
        test.reserve(stack);
        System.out.println(stack);
    }

    /**
     * 获取并移除栈底最后一个元素
     */
    private int getAndRemoveLastEle(Stack<Integer> stack) {
        Integer ele = stack.pop();
        if (stack.isEmpty()) {
            return ele;
        } else {
            int last = getAndRemoveLastEle(stack);
            stack.push(ele);
            return last;
        }
    }

    /**
     * 翻转
     */
    public void reserve(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            // 所有的栈底元素获取出来后 stack.push()
            return;
        }
        // 每进入下一层递归，都会把当时栈底元素获取出来，执行到最后一层时，栈中元素已经按照地递归层级翻转
        int ele = getAndRemoveLastEle(stack);
        reserve(stack);
        stack.push(ele);
    }

}
