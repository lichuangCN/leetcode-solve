package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2022/11/24
 * @description
 */
public class $5_longestPalindrome {

    public String longestPalindrome(String s) {
        int begin = 0, end = 0;
        // 0 1 2 3 4 5
        // c a c c a c
        for (int i = 0; i < s.length(); i++) {
            int len1 = find(s, i, i);
            int len2 = find(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - begin)) {
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    private int find(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
