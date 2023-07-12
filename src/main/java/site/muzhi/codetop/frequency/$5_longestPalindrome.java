package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/07/12
 * 5.最长回文子串
 * a.回文子串存在两种情况：奇数长度、偶数长度，需要同时遍历这两种情况
 * b.得到全部的回文子串，比较获取目标值
 */
public class $5_longestPalindrome {

    // 输入：s = "babad"
    // 输出："bab"
    // 解释："aba" 同样是符合题意的答案。
    public String longestPalindrome(String s) {
        if (s == null || "".equals(s) || s.length() == 1) {
            return s;
        }
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            String ans1 = check(s, i, i);
            // 偶数
            String ans2 = check(s, i, i + 1);
            // 取最长的值
            String ans3 = ans1.length() > ans2.length() ? ans1 : ans2;
            ans = ans.length() > ans3.length() ? ans : ans3;
        }
        return ans;
    }

    /**
     * 返回满足的回文子串
     */
    private String check(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            //
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
