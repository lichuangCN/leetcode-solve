package site.muzhi.codetop.frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2023/07/21
 * 22.括号生成
 */
public class $22_generateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        travel(ans, "", 0, 0, n);
        return ans;
    }

    private void travel(List<String> ans, String curr, int leftCount, int rightCount, int n) {
        if (leftCount == n && rightCount == n) {
            ans.add(curr);
            return;
        }
        if (rightCount > leftCount || leftCount > n || rightCount > n) {
            return;
        }
        travel(ans, new String(curr + "("), leftCount + 1, rightCount, n);
        travel(ans, new String(curr + "("), leftCount, rightCount + 1, n);
    }
}
