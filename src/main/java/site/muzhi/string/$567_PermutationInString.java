package site.muzhi.string;

/**
 * @author: lichuang
 * @date: 2020/03/18
 * @description: 给定两个字符串 s1 和 s2，
 * 写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 */

public class $567_PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // 统计子串s1中字符出现的次数，和s2中第一个窗口中字符出现的次数
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        // 处理s2中剩余的元素
        for (int i = s1.length(); i < s2.length(); i++) {
            if (check(s1Map, s2Map)) {
                return true;
            }
            // 移除窗口第一个元素
            s2Map[s2.charAt(i - s1.length()) - 'a']--;
            // 新增下一个进入窗口的元素
            s2Map[s2.charAt(i) - 'a']++;
        }
        return check(s1Map, s2Map);
    }

    /**
     * 比较两个窗口中字符出现次数是否相同
     *
     * @param array1
     * @param array2
     * @return
     */
    public boolean check(int[] array1, int[] array2) {
        for (int i = 0; i < 26; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
