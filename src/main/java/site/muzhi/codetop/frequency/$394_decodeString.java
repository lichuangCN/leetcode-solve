package site.muzhi.codetop.frequency;

import java.util.Stack;

/**
 * @author lichuang
 * @date 2023/08/02
 * 394.字符串解码
 */
public class $394_decodeString {

    // 输入：s = "3[a2[c]]"
    // 输出："accaccacc"

    // 输入：s = "abc3[cd]xyz"
    // 输出："abccdcdcdxyz"
    public String decodeString(String s) {
        char[] arr = s.toCharArray();

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        // 记录每个片段最内层的字符串
        StringBuilder t = new StringBuilder();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                num = num * 10 + arr[i] - '0';
                continue;
            }
            if (arr[i] == '[') {
                numStack.push(num);
                strStack.push(t.toString());
                num = 0;
                t = new StringBuilder();
                continue;
            }
            if (arr[i] == ']') {
                int count = numStack.pop();
                StringBuilder curr = new StringBuilder();
                for (int c = 0; c < count; c++) {
                    curr.append(t);
                }
                // 和前置已经完成的字符串拼接生成内部子串
                t = new StringBuilder(strStack.pop() + curr);
                continue;
            }
            // 字母
            t.append(arr[i]);
        }
        return t.toString();
    }
}
