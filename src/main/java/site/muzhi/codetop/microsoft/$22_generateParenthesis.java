package site.muzhi.codetop.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2022/11/18
 * 22.括号生成
 */
public class $22_generateParenthesis {

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>(0);
        }
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String curr, int leftCount, int rightCount, int n) {
        // 不满足条件
        if (leftCount > n || rightCount > n) {
            return;
        }
        if (leftCount == n && rightCount == n) {
            ans.add(curr);
        }

        if (leftCount >= rightCount) {
            String next = new String(curr);
            backtrack(ans, next + "(", leftCount + 1, rightCount, n);
            backtrack(ans, next + ")", leftCount, rightCount + 1, n);
        }
    }
}
