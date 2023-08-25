package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/10/27
 * @description 剑指 Offer 58 - I. 翻转单词顺序
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class $58_1_ReverseWords {

    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        // 去除首尾空格
        s = s.trim();
        int left = s.length() - 1, right = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (left >= 0) {
            while (left >= 0 && ' ' != s.charAt(left)) {
                left--;
            }
            // 检测到一个单词 [left+1,right]
            sb.append(s.subSequence(left + 1, right + 1)).append(" ");
            while (left >= 0 && ' ' == s.charAt(left)) {
                left--;
            }
            // 找到下一个单词的最后一个字符
            right = left;
        }
        return sb.toString().trim();
    }

    /**
     * API调用
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        String[] splitArr = s.split(" ");
        // 翻转数组元素
        StringBuilder res = new StringBuilder();
        for (int j = splitArr.length - 1; j >= 0; j--) {
            String str = splitArr[j];
            if (!"".equals(str)) {
                res.append(str).append(" ");
            }
        }
        return res.toString().trim();
    }
}
