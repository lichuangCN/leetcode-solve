package site.muzhi.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/02/01
 * 22.括号生成
 * 递归 + 回溯
 */
public class $22_generateParenthesis {

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>(0);
        }
        List<String> ans = new ArrayList<>();
        travel(ans, "", 0, 0, n);
        return ans;
    }

    private void travel(List<String> ans, String curr, int left, int right, int n) {
        // 非法字符
        if (left > n || right > n) {
            return;
        }
        // 满足条件
        if (left == n && right == n) {
            ans.add(curr);
        }
        // 左括号应该始终大于等于右括号才合法
        if (left >= right) {
            travel(ans, curr + "(", left + 1, right, n);
            travel(ans, curr + ")", left, right + 1, n);
        }
    }
}
