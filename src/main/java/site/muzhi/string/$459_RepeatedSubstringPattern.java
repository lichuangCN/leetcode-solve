package site.muzhi.string;

/**
 * @author lichuang
 * @date 2020/08/25
 * @description 重复的子字符串
 * <p>
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class $459_RepeatedSubstringPattern {

    /**
     * 暴力匹配求解
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }

        int strLen = s.length();
        for (int i = 1; i <= strLen / 2; i++) {
            // 主串长度不是当前子串长度的整倍数
            if (strLen % i != 0) {
                continue;
            }
            // 当前子串
            String subStr = s.substring(0, i);
            // 子串与主串匹配
            int k;
            for (k = i; k < strLen; k += i) {
                // 后面同等长度的子串
                String subStr2 = s.substring(k, k + i);
                // 后续子串存在不同，表示当前子串长度不符合
                if (!subStr2.equals(subStr)) {
                    break;
                }
            }
            // 当前子串完全匹配后面子串
            if (k == strLen) {
                return true;
            }
        }
        return false;
    }
}
