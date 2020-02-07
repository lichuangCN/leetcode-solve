package site.muzhi.solve;

import java.util.Stack;

/**
 * Author: lichuang
 * Date: 2020/02/07
 * Description:
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */
public class ValidateStackSequences946 {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度 O(n)
     *
     * @param pushed 入栈队列
     * @param popped 出栈队列
     * @return
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        // popped队列的索引
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            // 当栈顶元素和弹出队列对头元素相同时,弹出栈顶元素,并且出栈队列后移一位
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                // 符合满足弹出的条件后，弹出队列索引后移
                index++;
            }
        }
        // 若临时栈中不存在数据,说明popped队列符合出栈队列
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
