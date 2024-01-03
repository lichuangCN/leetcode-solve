package site.muzhi.leetcode.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/12/26
 * 1023.驼峰是式匹配
 */
public class $1023_camelMatch {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (String s : queries) {
            boolean flag = true;
            // 双指针 对目标串和模式串进行匹配
            int st = 0, pt = 0;
            while (st < s.length()) {
                char c = s.charAt(st);
                // 模式串匹配命中
                if (pt < pattern.length() && pattern.charAt(pt) == c) {
                    st++;
                    pt++;
                } else {
                    // 未匹配
                    if (Character.isUpperCase(c)) {
                        // 1.如果是大写字符，则与规则相悖
                        flag = false;
                        break;
                    } else {
                        // 如果是小写字符 继续遍历
                        st++;
                    }
                }
            }
            // 2.未完整匹配模式串
            if (pt < pattern.length()) {
                flag = false;
            }
            ans.add(flag);
        }
        return ans;
    }
}
