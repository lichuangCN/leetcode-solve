package site.muzhi.leetcode.interview;

/**
 * @author lichuang
 * @date 2021/01/23
 * @description 字符串轮转
 */
public class $01_09_IsFlipedString {

    public boolean isFlipedString_1(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        // 如果s2是s1旋转拼接的，则s2+s2中一定有字符串s1
        String ns = s2 + s2;
        return ns.contains(s1);
    }

    /**
     * 通过不断拼接比较，时间复杂度，空间复杂度都挺高
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString_2(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int idx = 0;
        int len = s1.length();
        while (idx < len) {
            StringBuilder builder = new StringBuilder();
            builder.append(s1.subSequence(idx, len))
                    .append(s1.subSequence(0, idx));
            if (builder.toString().equals(s2)) {
                return true;
            }
            idx++;
        }

        return false;
    }
}
