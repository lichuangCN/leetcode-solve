package site.muzhi.leetcode.group.offerII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/06/28
 * 87.复原IP
 */
public class $87_restoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();

        travel(ans, new ArrayDeque<>(), s.toCharArray(), 0);
        return ans;
    }

    private void travel(List<String> ans, Deque<String> curr, char[] arr, int idx) {
        // 满足条件
        if (curr.size() == 4 && idx == arr.length) {
            ans.add(String.join(".", curr));
            return;
        }

        // 后续已经不满足条件
        if (curr.size() == 4 && idx != arr.length) {
            return;
        }

        // 向后寻找三位字符
        for (int i = idx; i < idx + 3; i++) {
            // 超过字符串长度 终止
            if (i >= arr.length) {
                break;
            }
            // 校验 [i,i]/[i,i+1]/[i,i+2]
            String c = new String(arr, idx, i - idx + 1);
            if (check(c)) {
                curr.addLast(c);
                travel(ans, curr, arr, i + 1);
                curr.removeLast();
            }
        }
    }

    private boolean check(String s) {
        // 010 ...
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        Integer num = Integer.valueOf(s);
        return num >= 0 && num <= 255;
    }
}
