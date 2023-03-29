package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/03/29
 * 最多删除一个字符得到回文
 */
public class $19_validPalindrome {

    public boolean validPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        char[] array = s.toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
                continue;
            }
            // 判断 内部剩余的元素是否能够满足回文串
            return (isPalindrome(array, left + 1, right) || isPalindrome(array, left, right - 1));
        }
        return true;
    }

    public boolean isPalindrome(char[] s, int left, int right) {
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
