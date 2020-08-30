package site.muzhi.string;

/**
 * @author: lichuang
 * @date: 2020/03/11
 * @description: 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */

public class $557_ReverseWordsInASring3 {

    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            // 不使用字符串的翻转函数
            for (int i = string.length() - 1; i >= 0; i--) {
                builder.append(string.charAt(i));
            }
            builder.append(" ");
        }
        // 去除尾部空格
        return builder.toString().trim();
    }
}
