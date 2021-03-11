package site.muzhi.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2021/03/11
 * @description 计算器
 */
public class $227_Calculate {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        // 记录上一个操作符
        char ops = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // 当前位数是操作符
            // 并且根据题目要求，表达式的最后一位是整数
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (ops) {
                    case '+':
                        stack.addLast(num);
                        break;
                    case '-':
                        stack.addLast(-num);
                        break;
                    case '*':
                        stack.addLast(stack.removeLast() * num);
                        break;
                    case '/':
                        stack.addLast(stack.removeLast() / num);
                        break;
                }
                ops = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
