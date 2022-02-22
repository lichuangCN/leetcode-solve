package site.muzhi.leetcode.dp;

/**
 * @author lichuang
 * @date 2022/02/22
 * @description 392. 判断子序列
 * <p>
 * https://leetcode-cn.com/problems/is-subsequence/
 * <p>
 * 进阶题解参考
 * https://leetcode-cn.com/problems/is-subsequence/solution/dui-hou-xu-tiao-zhan-de-yi-xie-si-kao-ru-he-kuai-s/
 */
public class $392_IsSubsequence {

    /**
     * 双指针解法
     */
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int sp = 0, tp = 0;
        while (sp < sLen && tp < tLen) {
            // 匹配到，子串指针右移
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }
        // 子串匹配完毕
        return sp == sLen;
    }
}
