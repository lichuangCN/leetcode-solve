package site.muzhi.array;

/**
 * @author lichuang
 * @date 2021/03/08
 * @description 分割回文串 II
 */
public class $132_MinCut {

    int len;
    char[] arr;

    public int minCut(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        len = s.length();
        arr = s.toCharArray();
        int[] dp = new int[len];
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < len; i++) {
            if (isPalindrome(0, i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(j+1, i)) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[len - 1];
    }

    public boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
