package site.muzhi.codetop.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/01/04
 */
public class $438_findAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || "".equals(s) || p == null || "".equals(p)) {
            return new ArrayList<>(0);
        }
        List<Integer> ans = new ArrayList<>();

        int[] pCount = new int[26], wCount = new int[26];
        int pLen = p.length(), sLen = s.length();

        // 初始化目标子串的元素出现次数
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        // 遍历
        int l = 0, r = 0;
        for (r = 0; r < sLen; r++) {
            wCount[s.charAt(r) - 'a']++;
            // 窗口大小大于p，则从左向右减小窗口大小
            if (r - l + 1 > pLen) {
                wCount[s.charAt(l++) - 'a']--;
            }
            if (check(pCount, wCount)) {
                // 满足条件
                ans.add(l);
            }
        }
        return ans;
    }

    private boolean check(int[] pCount, int[] wCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != wCount[i]) {
                return false;
            }
        }
        return true;
    }
}
