package site.muzhi.codetop.microsoft;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lichuang
 * @date 2022/11/27
 * @description 复原 IP 地址
 */
public class $93_restoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || "".equals(s) || s.length() < 4 || s.length() > 12) {
            return ans;
        }
        travel(s, s.length(), 0, 4, new ArrayDeque<>(), ans);
        return ans;
    }

    private void travel(String s, int len, int begin, int splitCount, Deque<String> path, List<String> ans) {
        // 遍历到队尾
        if (begin == len) {
            //  且已经凑够四组数据
            if (splitCount == 0) {
                ans.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                // 字符串已经遍历完
                break;
            }
            // 剪枝 剩余字符串长度超过可分地址长度
            // 如 1231241 , 从字符串中分出两个 地址段，明显不满足
            if (len - i > splitCount * 3) {
                continue;
            }


            if (check(s, begin, i)) {
                path.addLast(s.substring(begin, i + 1));
                travel(s, len, i + 1, splitCount - 1, path, ans);
                path.removeLast();
            }
        }
    }

    private boolean check(String s, int begin, int end) {
        int len = end - begin + 1;
        if (len > 1 && s.charAt(begin) == '0') {
            return false;
        }

        Integer code = Integer.valueOf(s.substring(begin, end + 1));
        return code >= 0 && code <= 255;
    }
}
