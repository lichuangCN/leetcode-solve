package site.muzhi.leetcode.group.tencent50;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/10/25
 * 20 有效的括号
 */
public class $20_isValid {

    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
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
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
