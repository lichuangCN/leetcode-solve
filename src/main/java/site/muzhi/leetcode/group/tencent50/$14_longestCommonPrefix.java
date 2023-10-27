package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/23
 * 14.最长公共前缀
 */
public class $14_longestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        int len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            len = Math.min(len, strs[i].length());
        }

        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return ans.toString();
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }
}
