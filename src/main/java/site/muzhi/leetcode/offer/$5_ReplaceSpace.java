package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/11/23
 * @description 剑指 Offer 05. 替换空格
 * <p>
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
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

    /**
     * 奇淫技巧 哈哈哈
     */
    public String replaceSpace_2(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        return s.replaceAll(" ","%20");
    }
}
