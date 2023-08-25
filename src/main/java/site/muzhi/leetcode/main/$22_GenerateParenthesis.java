package site.muzhi.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LiChuang
 * @date: 2020/02/26
 * @description: 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 算法思想:递归，遍历出所有满足条件的括号组合
 * 裁剪法：递归过程中移除不满足条件的组合
 */
public class $22_GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    /**
     * @param results
     * @param str        当前的字符串
     * @param leftCount  左括号的数目
     * @param rightCount 右括号的数目
     * @param n
     */
    public void backtrack(List<String> results, String str, int leftCount, int rightCount, int n) {
        // 停止条件
        if (leftCount > n || rightCount > n) {
            return;
        }
        // 满足括号数目
        if (leftCount == n && rightCount == n) {
            results.add(str);
        }
        // 左括号的数目要大于等于右括号
        if (leftCount >= rightCount) {
            String s = new String(str);
            // 在当前的字符串上拼接一个 (
            backtrack(results, str + "(", leftCount + 1, rightCount, n);
            // 在当前的字符串上拼接一个 )
            backtrack(results, s + ")", leftCount, rightCount + 1, n);
        }
    }
}
