package site.muzhi.leetcode.offerII;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/06/19
 * 88.分隔回文子字符串
 */
public class $86_partition {

    public String[][] partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        travel(ans, new ArrayDeque<>(), s.toCharArray(), 0);

        String[][] res = new String[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            List<String> t = ans.get(i);
            String[] st = new String[t.size()];
            for (int j = 0; j < t.size(); j++) {
                st[j] = t.get(j);
            }
            res[i] = st;
        }
        return res;
    }

    private void travel(List<List<String>> ans, Deque<String> curr, char[] s, int idx) {
        if (idx == s.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i < s.length; i++) {
            if (check(s, idx, i)) {
                curr.addLast(new String(s, idx, i - idx + 1));
                travel(ans, curr, s, i + 1);
                curr.removeLast();
            }
        }
    }

    private boolean check(char[] s, int left, int right) {
        while (left < right) {
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
