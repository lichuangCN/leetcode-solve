package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/03/29
 * 有效的回文
 */
public class $18_isPalindrome {

    public boolean isPalindrome(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        String lowerS = s.toLowerCase();

        StringBuilder builder = new StringBuilder();
        for (char c : lowerS.toCharArray()) {
            if ((c - 'a' >= 0 && c - 'a' < 26) || (c - '0' >= 0 && c - '0' < 10)) {
                builder.append(c);
            }
        }
        String dest = builder.toString();
        String reverse = builder.reverse().toString();
        return dest.equals(reverse);
    }

}
