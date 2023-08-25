package site.muzhi.leetcode.main;

import java.util.LinkedList;

/**
 * @author: LiChuang
 * @date: 2020/02/29
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class $20_ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }

        char[] chars = s.toCharArray();
        // 保存出现的左侧符号
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : chars) {
            // 如果是左侧符号
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 如果栈内为空，表明此时出现右侧符号非法
                if (stack.isEmpty()) {
                    return false;
                }
                // 如果是右侧符号，取出栈顶元素
                char ch = stack.poll();
                switch (c) {
                    case '}':
                        if (ch != '{') {
                            return false;
                        }
                        break;
                    case ')':
                        if (ch != '(') {
                            return false;
                        }
                        break;
                    default:
                        if (ch != '[') {
                            return false;
                        }
                }
            }
        }
        // 如果合法
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
