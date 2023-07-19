package site.muzhi.codetop.frequency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/19
 * 93.复原IP地址
 */
public class $93_restoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        travel(ans, new ArrayDeque<>(), s, 0);
        return ans;
    }

    private void travel(List<String> ans, Deque<String> curr, String s, int idx) {
        if (curr.size() == 4 && idx == s.length()) {
            ans.add(String.join(".", curr));
            return;
        }
        if (curr.size() == 4 && idx < s.length()) {
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
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        return Integer.valueOf(s) >= 0 && Integer.valueOf(s) <= 255;
    }
}
