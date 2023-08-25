package site.muzhi.leetcode.string;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2020/11/16
 * @description 移掉k个数字
 */
public class $402_RemoveKDigits_2 {
    public String removeKdigits(String num, int k) {
        if (num == null || k <= 0) {
            return num;
        }
        LinkedList<Character> deque = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            // 当栈顶的元素大于此位的数值时，弹出栈中元素
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                // 弹出的元素表明是要移除的数值，当满足移除个数时，不再移除元素
                k--;
            }
            deque.addLast(digit);
        }
        // 如果仍有部分元素没有移除
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        // 结果元素
        StringBuilder builder = new StringBuilder();
        boolean startWithZero = true;
        for (Character c : deque) {
            if (c == '0' && startWithZero) {
                continue;
            }
            startWithZero = false;
            builder.append(c);
        }
        return builder.toString().length() == 0 ? "0" : builder.toString();
    }
}
