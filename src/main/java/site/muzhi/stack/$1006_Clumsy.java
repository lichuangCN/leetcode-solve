package site.muzhi.stack;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/04/01
 * @description 笨阶乘
 * <p>
 * https://leetcode-cn.com/problems/clumsy-factorial/
 */
public class $1006_Clumsy {

    public int clumsy(int n) {

        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        int opt = 0;
        for (int i = n - 1; i > 0; i--) {
            switch (opt) {
                case 0:
                    stack.push(stack.pop() * i);
                    break;
                case 1:
                    stack.push(stack.pop() / i);
                    break;
                case 2:
                    stack.push(i);
                    break;
                case 3:
                    stack.push(i * (-1));
                    break;
            }
            opt = (opt + 1) % 4;
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
