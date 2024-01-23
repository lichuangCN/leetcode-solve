package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lichuang
 * @date 2024/01/22
 * 402.移掉K位数字
 */
public class $402_removeKdigits {

    public String removeKdigits(String num, int k) {
        Deque<Character> queue = new ArrayDeque<>();

        // 1 queue 非递减序列
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!queue.isEmpty() && k > 0 && queue.peekLast() > c) {
                queue.pollLast();
                k--;
            }
            queue.offerLast(c);
        }

        // 移除剩余的部分 那就移除后面最大的数字
        for (int i = 0; i < k; i++) {
            queue.pollLast();
        }

        // 处理前置0
        StringBuilder ans = new StringBuilder();
        boolean zero = true;
        while (!queue.isEmpty()) {
            Character c = queue.pollFirst();
            if (zero && c == '0') {
                continue;
            }
            zero = false;
            ans.append(c);
        }

        return ans.toString().length() == 0 ? "0" : ans.toString();
    }
}
