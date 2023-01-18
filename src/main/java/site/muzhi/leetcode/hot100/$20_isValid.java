package site.muzhi.leetcode.hot100;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/01/18
 * 20.有效括号
 */
public class $20_isValid {

    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return false;
        }
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : array) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            switch (c) {
                case ')':
                    if (stack.pop() != '(') return false;
                case ']':
                    if (stack.pop() != '[') return false;
                case '}':
                    if (stack.pop() != '{') return false;
            }
        }
        return true;
    }
}
