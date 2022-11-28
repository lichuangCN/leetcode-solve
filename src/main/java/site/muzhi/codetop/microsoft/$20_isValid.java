package site.muzhi.codetop.microsoft;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2022/11/28
 * @description 20. 有效的括号
 */
public class $20_isValid {

    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) {
                stack.add(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char left = stack.pop();
            if (')' == c) {
                if (left != '(') {
                    return false;
                }
            } else if ('}' == c) {
                if (left != '{') {
                    return false;
                }
            } else {
                if (left != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
