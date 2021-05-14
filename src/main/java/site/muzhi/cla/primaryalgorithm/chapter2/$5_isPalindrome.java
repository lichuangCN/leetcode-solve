package site.muzhi.cla.primaryalgorithm.chapter2;

/**
 * @author lichuang
 * @date 2021/05/14
 * @description 验证回文串
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 */
public class $5_isPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        char[] arr = s.toLowerCase().toCharArray();
        int len = arr.length;
        int left = 0, right = len - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(arr[left]) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(arr[right]) && left < right) {
                right--;
            }
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
