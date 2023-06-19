package site.muzhi.leetcode.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/06/19
 * 85.生成匹配的括号
 */
public class $85_generateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        travel(ans, "", n, 0, 0);
        return ans;
    }

    public void travel(List<String> ans, String curr, int n, int leftCount, int rightCount) {
        if (leftCount > n | rightCount > n) {
            return;
        }
        if (leftCount == n && rightCount == n) {
            ans.add(curr);
            return;
        }
        if (leftCount >= rightCount) {
            String next = new String(curr);
            travel(ans, next + "(", n, leftCount + 1, rightCount);
            travel(ans, next + ")", n, leftCount, rightCount + 1);
        }
    }
}
