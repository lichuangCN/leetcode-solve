package site.muzhi.codetop.frequency;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/07/12
 * 20.有效括号
 */
public class $20_isValid {

    public boolean isValid(String s) {

        if (s == null || "".equals(s) || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
