package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/08
 * 338.比特位计数
 */
public class $338_countBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = (i & 1) == 1 ? ans[i / 2] + 1 : ans[i / 2];
        }
        return ans;
    }
}
