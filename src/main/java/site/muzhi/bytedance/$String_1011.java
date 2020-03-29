package site.muzhi.bytedance;

/**
 * @author: lichuang
 * @date: 2020/03/27
 * @description: 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */

public class $String_1011 {
    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        String[] words = s.split(" ");
        if (words.length == 0) {
            return "";
        }
        // 单词数组中可能会存在一个""字符，在拼接的时候要过滤掉
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (!"".equals(word)) {
                builder.append(words[i]).append(" ");
            }
        }
        String result = builder.toString();
        return result.substring(0, result.length() - 1);
    }
}
