package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/12/06
 * @description 1816. 截断句子
 * <p>
 * https://leetcode-cn.com/problems/truncate-sentence/
 */
public class $1816_TruncateSentence {

    /**
     * 单次遍历
     */
    public String truncateSentence_2(String s, int k) {
        if (s == null || "".equals(s)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int i = 0, cnt = 0;
        for (; i < s.length() && cnt <= k; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                cnt++;
            }
            if (cnt < k) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * 通过' '拆分为单词数组
     */
    public String truncateSentence_1(String s, int k) {
        if (s == null || "".equals(s)) {
            return "";
        }
        String[] words = s.split(" ");
        if (k > words.length) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            builder.append(words[i]).append(" ");
        }
        String str = builder.toString();
        str = str.substring(0, str.length() - 1);
        return str;
    }
}
