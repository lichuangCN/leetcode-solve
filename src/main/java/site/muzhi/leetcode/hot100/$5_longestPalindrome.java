package site.muzhi.leetcode.hot100;

/**
 * @author lichuang
 * @date 2023/01/18
 * 5.最长回文子串
 */
public class $5_longestPalindrome {

    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int begin = 0, end = 0;
        for (int i = 0; i < array.length; i++) {
            int odd = travel(array, i, i);
            int even = travel(array, i, i + 1);
            int len = Math.max(odd, even);
            /*
             * len = 偶数
             *   i
             * a a b b
             * 0 1 2 3
             * b     e
             * len = 4; i = 1
             * begin = i - len / 2 + 1  ==> 0
             * end = i + len / 2        ==> 3
             *
             * len = 奇数
             *     i
             * a a b c c
             * 0 1 2 3 4
             * b       e
             * len = 5; i = 2;
             * begin = i - len / 2      ==> 0
             * end = i + len / 2        ==> 4
             *
             * 在面对奇数和偶数 计算begin时存在误差
             * 可以转换为
             * begin = i - (len - 1) / 2
             * 即无论len为 奇数 或 偶数，保证计算结果一致
             */
            if (len > (begin - end)) {
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    public int travel(char[] array, int left, int right) {
        while (left > 0 && right < array.length && array[left] == array[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
