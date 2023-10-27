package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/19
 * 5.最长回文子串
 */
public class $5_longestPalindrome {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String ans = "";
        for (int i = 0; i < chars.length; i++) {
            String str1 = max(chars, i, i);
            String str2 = max(chars, i, i + 1);
            if (ans.length() < str1.length()) {
                ans = str1;
            }
            if (ans.length() < str2.length()) {
                ans = str2;
            }
        }
        return ans;
    }

    private String max(char[] chars, int left, int right) {
        while (left >= 0 && right <= chars.length - 1) {
            if (chars[left] != chars[right]) {
                break;
            }
            left--;
            right++;
        }
        return new String(chars, left + 1, right - left - 1);
    }
}
