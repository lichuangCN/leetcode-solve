package site.muzhi.leetcode.group.hot100;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/10/08
 * 394.字符串解码
 */
public class $394_decodeString {

    public String decodeString(String s) {
        char[] chars = s.toCharArray();

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        int num = 0;
        StringBuilder str = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                num = 0;
                strStack.push(str.toString());
                str = new StringBuilder();
            } else if (c == ']') {
                Integer count = numStack.pop();
                StringBuilder curr = new StringBuilder();
                for (Integer i = 0; i < count; i++) {
                    curr.append(str);
                }
                str = new StringBuilder(strStack.pop() + curr);
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}
