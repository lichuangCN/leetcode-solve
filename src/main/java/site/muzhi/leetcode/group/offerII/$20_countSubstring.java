package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/03/30
 * 回文子字符串的个数
 */
public class $20_countSubstring {

    public int countSubstrings(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int ans = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            // 向两侧遍历
            // 奇数
            int left = i, right = i;
            while (left >= 0 && right < array.length) {
                // 判断当前窗口是否回文
                if (isPalindrome(array, left, right)) {
                    ans++;
                }
                left--;
                right++;
            }
            // 偶数
            left = i;
            right = i + 1;
            while (left >= 0 && right < array.length) {
                // 判断当前窗口是否回文
                if (isPalindrome(array, left, right)) {
                    ans++;
                }
                left--;
                right++;
            }
        }

        return ans;
    }

    private boolean isPalindrome(char[] array, int left, int right) {
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
