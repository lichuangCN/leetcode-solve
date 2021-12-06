package site.muzhi.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @date 2021/03/31
 * @description
 */
public class $08_09_GenerateParenthesis {


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(n * 2);
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, String t, int left, int right, int n) {
        if (right > n || left > n) {
            return;
        }
        if (right == n && left == n) {
            res.add(t);
        }
        if (left >= right) {
            String ne = new String(t);
            backtrack(res, ne + "(", left + 1, right, n);
            backtrack(res, ne + ")", left, right + 1, n);
        }
    }
}
