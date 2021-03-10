package site.muzhi.day;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lichuang
 * @date 2020/09/19
 * @description 出现已经做过的题目时，在此类中完成此题的代码的编写
 */
public class TodayQuestion {

    public int calculate(String s) {
        int result = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case ' ':
                    break;
                case '(':
                    // 左侧结果和运算符入栈
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    sign = 1;
                    break;
                case ')':
                    // 左侧结果+'()'内的结果
                    result = stack.pop() * result + stack.pop();
                    break;
                case '-':
                    sign = -1;
                    break;
                case '+':
                    sign = 1;
                    break;
                default:
                    // 字母
                    int num = charArray[i] - '0';
                    while (i < charArray.length-1 && Character.isDigit(charArray[i + 1])) {
                        num = num * 10 + (charArray[++i] - '0');
                    }
                    result = result + num * sign;
                    break;
            }
        }
        return result;
    }

}
