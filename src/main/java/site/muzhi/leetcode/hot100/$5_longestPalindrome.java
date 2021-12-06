package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2021/04/06
 * @description 5. 最长回文子串
 * <p>
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class $5_longestPalindrome {

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int len1 = len(arr, i, i);
            int len2 = len(arr, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int len(char[] arr, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < arr.length && arr[L] == arr[R]) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
