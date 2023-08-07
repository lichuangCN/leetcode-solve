package site.muzhi.codetop.frequency;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/08/07
 * 227.基本计算器 II
 */
public class $227_calculate {

    public int calculate(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        // 记录上一个操作符
        char opt = '+';
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            }
            // 监测当前字符是操作符(即当前num数字已经找全), 通过判断上一个操作符，来判断本次入栈的num值
            boolean isOpt = !Character.isDigit(curr) && curr != ' ';
            // s.length() - 1 需要考虑空格的问题
            if (isOpt || i == s.length() - 1) {
                switch (opt) {
                    case '+':
                        numStack.push(num);
                        break;
                    case '-':
                        numStack.push(-num);
                        break;
                    case '*':
                        numStack.push(numStack.pop() * num);
                        break;
                    case '/':
                        numStack.push(numStack.pop() / num);
                        break;
                }
                // 重置
                opt = curr;
                num = 0;
            }
        }
        int ans = 0;
        while (!numStack.isEmpty()) {
            ans += numStack.pop();
        }
        return ans;
    }
}
