package site.muzhi.string;

/**
 * @author: lichuang
 * @date: 2020/03/08
 * @description: TODO
 */

public class $9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        // 复数或是十倍整数，不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 反转后的部分值
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        // 由于原始值x的位数可能是技术或是偶数
        // 前者表示原始值x为偶数，y正是后半部分反转后的值
        // 后者表示原始值x为奇数，此时反转后的值要比x多一位
        return x == y || x == y / 10;
    }

}
