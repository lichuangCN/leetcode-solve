package site.muzhi.leetcode.cla.primaryalgorithm.chapter2;

/**
 * @author lichuang
 * @date 2021/05/14
 * @description 反转字符串
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 */
public class $1_reverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int len = s.length;
        int left = 0, right = len - 1;
        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
    }

}
