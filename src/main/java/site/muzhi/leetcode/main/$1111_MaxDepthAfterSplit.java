package site.muzhi.leetcode.main;

/**
 * @author: lichuang
 * @date: 2020/04/01
 * @description:
 */

public class $1111_MaxDepthAfterSplit {

    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];

        int depth = 0, index = 0;
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                // 入栈，栈深度+1
                depth++;
                // 奇数or偶数
                result[index++] = depth & 1;
            } else {
                result[index++] = depth & 1;
                // 出栈，栈深度-1
                depth--;
            }
        }
        return result;
    }
}
