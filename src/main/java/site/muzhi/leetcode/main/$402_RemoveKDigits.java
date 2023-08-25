package site.muzhi.leetcode.string;

import java.util.LinkedList;

/**
 * @author: LiChuang
 * @date: 2020/02/22
 * @description:
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小
 *
 * 算法思想：采用栈的数据结构，保存可能小的字符
 */
public class $402_RemoveKDigits {

    public String removeKDigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        if (num == null || num.length() == 0 || k > num.length()) {
            return "0";
        }

        char[] array = num.toCharArray();
        // 遍历字符数组
        for (int i = 0; i < array.length; i++) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > array[i]) {
                // 第i个元素小于栈顶元素,移除栈顶元素
                stack.removeLast();
                k--;
            }
            stack.addLast(array[i]);
        }

        // 若没有移除指定个数的元素，则移除剩余个数的末尾元素
        for (int j = 0; j < k; j++) {
            stack.removeLast();
        }

        // 拼接栈内字符
        boolean leaderZero = true;
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            // 当首位为0时，不拼接
            if (leaderZero && character == '0') {
                continue;
            }
            leaderZero = false;
            sb.append(character);
        }
        // 当移除全部元素时，返回"0"
        if (sb.length() ==0) {
            return "0";
        }
        return sb.toString();
    }
}
