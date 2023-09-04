package site.muzhi.leetcode.main;

/**
 * @author: lichuang
 * @date: 2020/03/12
 * @description: 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，
 * 我们才认定 “T 能除尽 S”。
 * <p>
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 */
public class $1071_GreatestCommonDivisorOfStrings {

    /**
     * 本题的核心点有2个：1、如何让判断str1和str2是存在公共因子的；2、如何找到公共因子的长度
     * 1、有一个充分必要条件：str1+str2 = str2+str1，则表明二者是存在公共因子
     * 2、获取以两个字符串的长度的最大公约数，这个数的大小则表示公共因子的长度
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        // 如果说str1和str2有相同的公约字符串，str1+str2 = str2+str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * x和y的最大公约数
     *
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }

}
