package site.muzhi.leetcode.string;

/**
 * @author lichuang
 * @date 2021/12/04
 * @description1446. 连续字符
 * <p>
 * https://leetcode-cn.com/problems/consecutive-characters/
 */
public class $1446_MaxPower {

    public int maxPower(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int left = 0, right = 1, len = s.length();
        int max = 1;
        char[] array = s.toCharArray();
        while (right < len) {
            while (right < len && array[left] == array[right]) {
                right++;
            }
            max = Math.max(max, right - left);
            left = right;
            right++;
        }
        return max;
    }
}
