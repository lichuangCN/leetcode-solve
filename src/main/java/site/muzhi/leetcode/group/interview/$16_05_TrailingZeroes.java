package site.muzhi.leetcode.group.interview;

/**
 * @author lichuang
 * @date 2021/03/10
 * @description 阶乘尾数
 */
public class $16_05_TrailingZeroes {

    public int trailingZeroes(int n) {
        int sum = 0;
        while (n >= 5) {
            n /= 5;
            sum += n;
        }
        return sum;
    }
}
