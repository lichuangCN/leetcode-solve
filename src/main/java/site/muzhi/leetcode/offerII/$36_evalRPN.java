package site.muzhi.leetcode.offerII;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/04/21
 * 36.后缀表达式
 */
public class $36_evalRPN {

    public static void main(String[] args) {
        $36_evalRPN demo = new $36_evalRPN();
        String[] s = {"4", "13", "5", "/", "+"};
        demo.evalRPN(s);
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            int op1, op2;
            switch (token) {
                case "*":
                    op1 = numStack.pop();
                    op2 = numStack.pop();
                    numStack.push(op2 * op1);
                    break;
                case "/":
                    op1 = numStack.pop();
                    op2 = numStack.pop();
                    numStack.push(op2 / op1);
                    break;
                case "+":
                    op1 = numStack.pop();
                    op2 = numStack.pop();
                    numStack.push(op2 + op1);
                    break;
                case "-":
                    op1 = numStack.pop();
                    op2 = numStack.pop();
                    numStack.push(op2 - op1);
                    break;
                default:
                    numStack.push(Integer.valueOf(token));
            }
        }
        return numStack.pop();
    }
}
