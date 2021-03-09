package site.muzhi.string;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lichuang
 * @date 2021/03/09
 * @description
 */
public class $1047_RemoveDuplicates {

    public String removeDuplicates(String S) {
        if (S == null || "".equals(S)) {
            return null;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Character character : stack) {
            builder.append(character);
        }
        return builder.toString();
    }
}
