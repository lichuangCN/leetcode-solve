package site.muzhi.leetcode.main;

import java.util.Stack;

/**
 * Author: lichuang
 * Date: 2020/02/07
 * Description:
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 算法核心思想：将每一对() 作为一个整体计算,每计算出来一个()的结果后要与左侧进行计算。
 * <p>
 * 正序迭代字符串。
 * 1.操作数可以由多个字符组成，字符串 "123" 表示数字 123，它可以被构造为：123 >> 120 + 3 >> 100 + 20 + 3。如果我们读取的字符是一个数字，则我们要将先前形成的操作数乘以 10 并于读取的数字相加，形成操作数。
 * 2.每当我们遇到 + 或 - 运算符时，我们首先将表达式求值到左边，然后将正负符号保存到下一次求值。
 * 3.如果字符是左括号 (，我们将迄今为止计算的结果和符号添加到栈上，然后重新开始进行计算，就像计算一个新的表达式一样。
 * 4.如果字符是右括号 )，则首先计算左侧的表达式。则产生的结果就是刚刚结束的子表达式的结果。如果栈顶部有符号，则将此结果与符号相乘。
 */
public class $224_BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        char[] chars = s.toCharArray();
        // sign表示运算符 1:+,-1:-;result表示结果
        int sign = 1, result = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case ' ':
                    // 出现空格
                    break;
                case '(':
                    // 把当前左侧结果保存入栈
                    stack.push(result);
                    // 重置左侧结果
                    result = 0;
                    // 把当前运算符入栈
                    stack.push(sign);
                    // 重置运算符
                    sign = 1;
                    break;
                case ')':
                    // 第一个出栈是将当前()内的值和当前()前面的运算符匹配
                    // 第二个出栈是当前()左侧已经计算好的结果
                    result = stack.pop() * result + stack.pop();
                    break;
                case '-':
                    sign = -1;
                    break;
                case '+':
                    sign = 1;
                    break;
                default:
                    // 出现字符为数值
                    int num = chars[i] - '0';
                    while (i < chars.length - 1 && Character.isDigit(chars[i + 1])) {
                        // 转为整数
                        num = num * 10 + (chars[++i] - '0');
                    }
                    // 计算左右值
                    result = result + num * sign;
                    break;
            }
        }

        return result;
    }
}
