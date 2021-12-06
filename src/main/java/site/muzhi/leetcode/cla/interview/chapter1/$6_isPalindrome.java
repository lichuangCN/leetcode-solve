package site.muzhi.leetcode.cla.interview.chapter1;

/**
 * @author lichuang
 * @date 2021/04/13
 * @description 验证回文串
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions/xah8k6/
 */
public class $6_isPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        String ns = s.toLowerCase();
        char[] arr = ns.toCharArray();
        int left = 0, right = ns.length() - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(arr[left]) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(arr[right]) && left < right) {
                right--;
            }
            if (left < right) {
                if (arr[left] != arr[right]) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
