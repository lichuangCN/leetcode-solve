package site.muzhi.leetcode.main;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/04/01
 * @description 逆波兰表达式
 * <p>
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class $150_EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
                continue;
            }
            if ("/".equals(token)) {
                Integer var1 = stack.pop();
                Integer var2 = stack.pop();
                stack.push(var2 / var1);
                continue;
            }
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
                continue;
            }
            if ("-".equals(token)) {
                Integer var1 = stack.pop();
                Integer var2 = stack.pop();
                stack.push(var2 - var1);
                continue;
            }
            stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }
}
