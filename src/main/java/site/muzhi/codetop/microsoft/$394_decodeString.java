package site.muzhi.codetop.microsoft;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2022/12/08
 * @description 394. 字符串解码
 */
public class $394_decodeString {

    public String decodeString(String s) {
        // 其实记录的是每个回合的值
        StringBuilder ans = new StringBuilder();
        int num = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                // 入栈
                numStack.push(num);
                //
                strStack.push(ans.toString());
                // 重置0
                num = 0;
                ans = new StringBuilder();
            } else if (c == ']') {
                Integer currNum = numStack.pop();
                // 拼接当前字符串
                StringBuilder builder = new StringBuilder();
                for (Integer i = 0; i < currNum; i++) {
                    builder.append(ans.toString());
                }
                ans = new StringBuilder(strStack.pop() + builder.toString());
            } else if (c >= '0' && c <= '9') {
                // 数字
                num = num * 10 + (c - '0');
            } else {
                // 字符
                ans.append(c.toString());
            }
        }
        return ans.toString();
    }
}
