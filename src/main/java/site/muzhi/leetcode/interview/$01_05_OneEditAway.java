package site.muzhi.leetcode.interview;

/**
 * @author lichuang
 * @date 2021/01/21
 * @description 面试题 01.05. 一次编辑
 */
public class $01_05_OneEditAway {
    public boolean oneEditAway(String first, String second) {

        int fLen = first.length(), sLen = second.length();
        // 满足条件的两个字符串之间的长度差应该是0/1
        if (Math.abs(fLen - sLen) > 1) {
            return false;
        }
        int i = 0, f = fLen - 1, s = sLen - 1;
        while (i < fLen && i < sLen && first.charAt(i) == second.charAt(i)) {
            i++;
        }
        while (f >= 0 && s >= 0 && first.charAt(f) == second.charAt(s)) {
            f--;
            s--;
        }
        // 如果满足条件，则f与i的差值应该是0/-1,同样s与i的差值应该也是0/-1
        // 即 f-i<1 && s-i<1
        return (f - i < 1) && (s - i < 1);
    }
}
