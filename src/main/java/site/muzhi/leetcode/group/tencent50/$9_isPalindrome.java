package site.muzhi.leetcode.group.tencent50;

/**
 * @author lichuang
 * @date 2023/10/23
 * 9.回文数
 */
public class $9_isPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int re = 0, y = x;
        while (y != 0) {
            re = re * 10 + y % 10;
            y = y / 10;
        }
        return re == x;
    }
}
