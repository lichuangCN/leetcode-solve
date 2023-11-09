package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/11/09
 * 344.反转字符串
 */
public class $344_reverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
