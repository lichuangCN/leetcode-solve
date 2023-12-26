package site.muzhi.leetcode.main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/12/25
 * 93.复原IP地址
 */
public class $93_restoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();
        travel(ans, new ArrayDeque<>(), s, 0);
        return ans;
    }

    /**
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     */
    private void travel(List<String> ans, Deque<String> curr, String s, int idx) {
        if (idx != s.length() && curr.size() == 4) {
            return;
        }
        if (idx == s.length() && curr.size() != 4) {
            return;
        }
        // 满足条件
        if (idx == s.length() && curr.size() == 4) {
            ans.add(String.join(".", curr));
            return;
        }
        for (int i = idx; i < idx + 3 && i < s.length(); i++) {
            String str = s.substring(idx, i + 1);
            if (check(str)) {
                curr.addLast(str);
                travel(ans, curr, s, i + 1);
                curr.removeLast();
            }
        }
    }

    private boolean check(String s) {
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }
        int n = Integer.valueOf(s);
        return n >= 0 && n <= 255;
    }
}
