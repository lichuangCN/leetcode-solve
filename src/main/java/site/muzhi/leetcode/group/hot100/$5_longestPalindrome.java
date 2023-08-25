package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/08/18
 * 5.最长回文子串
 */
public class $5_longestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        String ans = "";
        for (int i = 0; i < len; i++) {
            String find1 = travel(chars, i, i);
            String find2 = travel(chars, i, i + 1);
            if (find1.length() > ans.length()) {
                ans = find1;
            }
            if (find2.length() > ans.length()) {
                ans = find2;
            }
        }

        return ans;
    }

    private String travel(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length) {
            if (chars[left] != chars[right]) {
                break;
            }
            left--;
            right++;
        }
        // a(l) b c b d(r)
        return new String(chars, left + 1, right - left - 1);
    }
}
