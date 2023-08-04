package site.muzhi.codetop.frequency;

/**
 * @author lichuang
 * @date 2023/08/04
 * 14.最长公共前缀
 */
public class $14_longestCommonPrefix {

    public static void main(String[] args) {
        $14_longestCommonPrefix demo = new $14_longestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        demo.longestCommonPrefix(strs);
    }

    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            len = Math.min(len, str.length());
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char curr = strs[0].charAt(i);
            for (int idx = 1; idx < strs.length; idx++) {
                if (curr != strs[idx].charAt(i)) {
                    return ans.toString();
                }
            }
            ans.append(curr);
        }
        return ans.toString();
    }
}
