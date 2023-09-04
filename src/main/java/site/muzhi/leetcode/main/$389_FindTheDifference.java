package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2020/12/24
 * @description 找不同
 * <p>
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 */
public class $389_FindTheDifference {

    /**
     * 统计个数
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char[] originArray = new char[26];
        char[] newArray = new char[26];
        for (int i = 0; i < s.length(); i++) {
            originArray[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            newArray[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (originArray[i] != newArray[i]) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }

    /**
     * 位运算
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            c ^= t.charAt(i);
        }
        return (char) c;
    }

    /**
     * 求和
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference3(String s, String t) {
        char[] originArray = s.toCharArray();
        char[] newArray = t.toCharArray();
        int sn = 0, tn = 0;
        for (char c : originArray) {
            sn += (c - 'a');
        }
        for (char c : newArray) {
            tn += (c - 'a');
        }
        return (char) (tn - sn + 'a');
    }

}
