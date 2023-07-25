package site.muzhi.codetop.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/25
 * 151.翻转字符串中的单词
 */
public class $151_reverseWords {

    public static void main(String[] args) {
        $151_reverseWords demo = new $151_reverseWords();
//        System.out.println(demo.reverseWords(" the  sky is blue "));
        System.out.println(demo.reverseWords("blue is sky the"));
    }

    // 输入：s = "the  sky is blue "
    // 输出："blue is sky the"
    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }

        List<String> words = new ArrayList<>();
        int pos = s.length() - 1;
        while (pos >= 0) {
            // 移除空格
            while (pos >= 0 && s.charAt(pos) == ' ') {
                pos--;
            }

            // 定位单词
            int r = pos;
            while (pos >= 0 && s.charAt(pos) != ' ') {
                pos--;
            }

            // 截断单词:
            // case 1: 原字符串有前置空格，则 s.charAt(pos + 1) == ' '
            // case 2: 原字符串没有前置空格，则 s.charAt(pos + 1) != ' '
            if (pos >= 0 || s.charAt(pos + 1) != ' ') {
                String word = s.substring(pos + 1, r + 1);
                words.add(word);
            }
        }
        return String.join(" ", words);
    }
}
