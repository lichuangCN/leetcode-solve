package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/12
 * 647.回文子串
 */
public class $647_countSubstrings {

    public int countSubstrings(String s) {

        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int left = i, right = i;
            while (left >= 0 && right <= s.length() - 1) {
                if (check(chars, left, right)) {
                    ans++;
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right <= s.length() - 1) {
                if (check(chars, left, right)) {
                    ans++;
                }
                left--;
                right++;
            }
        }
        return ans;
    }

    private boolean check(char[] chars, int left, int right) {
        while (left <= right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
