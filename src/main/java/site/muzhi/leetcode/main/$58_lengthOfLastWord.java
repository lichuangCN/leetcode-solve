package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/02
 * 58.最后一个单词的长度
 */
public class $58_lengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int idx = s.length() - 1;
        while (idx >= 0) {
            if (s.charAt(idx) == ' ') {
                break;
            }
            idx--;
        }
        return s.length() - idx - 1;
    }
}
