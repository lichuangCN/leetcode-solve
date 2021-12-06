package site.muzhi.leetcode.cla.primaryalgorithm.chapter2;

/**
 * @author lichuang
 * @date 2021/05/14
 * @description 字符串中的第一个唯一字符
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 */
public class $3_firstUniqChar {

    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        int[] count = new int[26];
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
