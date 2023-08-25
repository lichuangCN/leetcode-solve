package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/02/20
 * 5.单词长度的最大乘积
 */
public class $5_maxProduct {

    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i <= words.length - 1; i++) {
            for (int j = i + 1; j <= words.length - 1; j++) {
                if (!hasSameChar(words[i], words[j])) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    /**
     * 掩码计算
     */
    private boolean hasSameChar(String s1, String s2) {
        int bitMask1 = 0, bitMask2 = 0;
        for (char c : s1.toCharArray()) {
            bitMask1 |= 1 << (c - 'a');
        }
        for (char c : s2.toCharArray()) {
            bitMask2 |= 1 << (c - 'a');
        }
        return (bitMask1 & bitMask2) != 0;
    }

    //private boolean hasSameChar(String s1, String s2) {
    //    char[] count = new char[26];
    //    for (char c : s1.toCharArray()) {
    //        count[c - 'a']++;
    //    }
    //    for (char c : s2.toCharArray()) {
    //        if (count[c - 'a'] != 0) {
    //            return true;
    //        }
    //    }
    //    return false;
    //}
}
