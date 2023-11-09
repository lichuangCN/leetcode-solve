package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/09
 * 557.反转字符串中的单词 III
 */
public class $557_reverseWords {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                builder.append(word.charAt(i));
            }
            builder.append(" ");
        }
        String tar = builder.toString();
        return tar.substring(0, tar.length() - 1);
    }
}
