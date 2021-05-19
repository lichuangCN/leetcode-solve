package site.muzhi.cla.primaryalgorithm.chapter2;

/**
 * @author lichuang
 * @date 2021/05/16
 * @description 最长公共前缀
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 */
public class $9_longestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;
            for (; j < res.length() && j < str.length(); j++) {
                if (res.charAt(j) != str.charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            if ("".equals(res)) {
                return "";
            }
        }

        return res;
    }
}
