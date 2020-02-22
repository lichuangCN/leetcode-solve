package site.muzhi.greed;

import java.util.LinkedList;

/**
 * @author: LiChuang
 * @date: 2020/02/22
 * @description:
 */
public class RemoveKDigits {

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
