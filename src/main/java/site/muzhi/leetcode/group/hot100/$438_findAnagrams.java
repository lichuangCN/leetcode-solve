package site.muzhi.leetcode.group.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/10/11
 * 438.找到字符串中所有字母的异位词
 */
public class $438_findAnagrams {

    public static void main(String[] args) {
        $438_findAnagrams demo = new $438_findAnagrams();
        System.out.println(demo.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length(), sLen = s.length();
        int[] win = new int[26], tar = new int[26];
        for (int i = 0; i < pLen; i++) {
            tar[p.charAt(i) - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < sLen; i++) {
            win[s.charAt(i) - 'a']++;

            if (i > pLen - 1) {
                win[s.charAt(i - pLen) - 'a']--;
            }

            if (equals(win, tar)) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }

    private boolean equals(int[] win, int[] tar) {
        for (int i = 0; i < 26; i++) {
            if (win[i] != tar[i]) {
                return false;
            }
        }
        return true;
    }
}
