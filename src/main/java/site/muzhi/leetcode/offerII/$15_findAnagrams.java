package site.muzhi.leetcode.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/03/28
 */
public class $15_findAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || "".equals(s) || p == null || "".equals(p) || s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] target = new int[26];
        int[] window = new int[26];
        int sLen = s.length(), pLen = p.length();
        // 预处理第一组数据
        for (int i = 0; i < pLen; i++) {
            target[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        for (int i = pLen; i < sLen; i++) {
            if (compare(target, window)) {
                ans.add(i - pLen);
            }
            // 窗口移动
            window[s.charAt(i - pLen) - 'a']--;
            window[s.charAt(i) - 'a']++;
        }

        // 计算最后一组是否满足条件
        if (compare(target, window)) {
            ans.add(sLen - pLen);
        }
        return ans;
    }

    private boolean compare(int[] target, int[] window) {
        for (int i = 0; i < target.length; i++) {
            if (target[i] != window[i]) {
                return false;
            }
        }
        return true;
    }
}
