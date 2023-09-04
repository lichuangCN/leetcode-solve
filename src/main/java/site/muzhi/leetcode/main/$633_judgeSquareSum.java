package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/04/28
 * @description 633. 平方数之和
 * <p>
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class $633_judgeSquareSum {

    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int max = (int) Math.sqrt(c);
        int i = 0, j = max;
        while (i <= j) {
            int val = i * i + j * j;
            if (val == c) {
                return true;
            }
            if (val < c) {
                i++;
            }
            if (val > c) {
                j--;
            }
        }
        return false;
    }
}
