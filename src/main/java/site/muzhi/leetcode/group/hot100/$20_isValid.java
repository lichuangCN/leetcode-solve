package site.muzhi.leetcode.group.hot100;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/08/21
 * 20.有效的括号
 */
public class $20_isValid {

    //  '('，')'，'{'，'}'，'['，']'
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
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
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
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
