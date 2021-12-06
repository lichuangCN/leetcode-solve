package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/11/23
 * @description 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class $5_ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res.append("%20");
                continue;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
