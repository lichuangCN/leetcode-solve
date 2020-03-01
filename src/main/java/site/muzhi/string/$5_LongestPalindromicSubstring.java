package site.muzhi.string;

/**
 * @author: LiChuang
 * @date: 2020/03/01
 * @description:
 */
public class $5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        // 最长回文串的开始和结束索引
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 1.以第i个位置元素为中心点
            int len1 = expandFromCenter(s, i, i);
            // 2.以第i和i+1个位置元素的中间为中心点
            int len2 = expandFromCenter(s, i, i + 1);
            // 以上述两个中心点，得到的最长回文串的长度
            int len = Math.max(len1, len2);
            // 当前的回文子串大于等于之前最长回文子串，重新设定子串位置
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 由中心向两侧扩展
     *
     * @param str
     * @param left
     * @param right
     * @return
     */
    public int expandFromCenter(String str, int left, int right) {
        int L = left, R = right;
        // 向两边扩展，终止条件：1.到达边界；2向外扩展时，两侧的元素不同
        while (L >= 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
            L--;
            R++;
        }
        // 返回最长回文串的长度
        return R - L - 1;
    }
}
