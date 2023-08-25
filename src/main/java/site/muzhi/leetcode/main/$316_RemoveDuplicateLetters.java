package site.muzhi.leetcode.main;

import java.util.LinkedList;

/**
 * @author lichuang
 * @date 2020/12/21
 * @description 去除重复字母
 */
public class $316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }

        LinkedList<Character> stack = new LinkedList<>();
        // 当前栈中是否包含当前元素
        boolean[] contains = new boolean[26];
        char[] charArray = s.toCharArray();
        int len = charArray.length;

        // 记录每个元素出现的最后的位置
        int[] lastIdx = new int[26];
        for (int i = 0; i < len; i++) {
            lastIdx[charArray[i] - 'a'] = i;
        }

        for (int i = 0; i < len; i++) {
            char c = charArray[i];
            if (contains[c - 'a']) {
                continue;
            }
            // 当前元素小于栈顶元素，并且当前元素后面的字符串中包含当前栈顶的元素
            // 移除栈顶的元素
            while (!stack.isEmpty() && c < stack.peekLast() && lastIdx[stack.peekLast() - 'a'] > i) {
                Character topChar = stack.removeLast();
                contains[topChar - 'a'] = false;
            }
            stack.addLast(c);
            contains[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (Character c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }
}
