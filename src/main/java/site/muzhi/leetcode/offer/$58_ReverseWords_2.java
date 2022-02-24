package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2022/02/24
 * @description 剑指 Offer 58 - II. 左旋转字符串
 * <p>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class $58_ReverseWords_2 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || "".equals(s) || s.length() <= n) {
            return "";
        }
        return s.substring(n) + s.substring(0, n);
    }
}
