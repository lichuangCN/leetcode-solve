package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/04/20
 * @description
 */
public class $28_StrStr {

    public int strStr(String haystack, String needle) {

        if (needle == null || "".equals(needle)) {
            return 0;
        }

        int[] next = initNextArray(needle);

        // 目标串
        char[] t = haystack.toCharArray();
        // 模式串
        char[] p = needle.toCharArray();

        int i = 0, j = 0, sL = t.length, pL = p.length;
        while (i < sL && j < pL) {
            // 如果i==-1，表明匹配成功，然后i++,j++
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        //匹配成功，返回模式串p在文本串s中的位置，否则返回-1
        if (j == pL) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * 初始化next数组
     *
     * @param pattern
     * @return
     */
    private int[] initNextArray(String pattern) {
        int[] next = new int[pattern.length()];
        char[] p = pattern.toCharArray();

        int j = 0, k = -1;
        // 第一位设为-1，方便判断当前位置是否为搜索词的最开始
        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (k == -1 || p[j] == p[k]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
