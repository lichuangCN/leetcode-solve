package site.muzhi.leetcode.offerII;

/**
 * @author lichuang
 * @date 2023/03/08
 */
public class $14_checkInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] s1_count = new int[26];
        int[] win_count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1_count[s1.charAt(i) - 'a']++;
            win_count[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (compare(s1_count, win_count)) {
                return true;
            }
            char pre = s2.charAt(i - s1.length());
            char next = s2.charAt(i);
            win_count[pre - 'a']--;
            win_count[next - 'a']++;
        }
        // 比较最后一个窗口的数据
        return compare(s1_count, win_count);
    }

    private boolean compare(int[] s1, int[] win) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != win[i]) {
                return false;
            }
        }
        return true;
    }
}
