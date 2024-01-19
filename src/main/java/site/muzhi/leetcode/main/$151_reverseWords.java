package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/19
 * 151.反转字符串中的单词
 */
public class $151_reverseWords {

    public static void main(String[] args) {
        $151_reverseWords demo = new $151_reverseWords();
        demo.reverseWords("  hello world  ");
    }

    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        int len = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            // 移除空格
            if (' ' == s.charAt(i)) {
                continue;
            }
            // 单词最后一个字母
            int end = i;
            while (i >= 0 && ' ' != s.charAt(i)) {
                i--;
            }
            String word = s.substring(i + 1, end + 1);
            ans.append(word).append(" ");
        }

        String tar = ans.toString();
        return tar.substring(0, tar.length() - 1);
    }
}
