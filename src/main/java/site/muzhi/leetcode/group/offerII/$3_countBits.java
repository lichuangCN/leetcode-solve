package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2022/02/22
 * @description 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * <p>
 * https://leetcode-cn.com/problems/w3tCBm/
 */
public class $3_countBits {

    /**
     * i:偶数 ans[i] = ans[i/2]
     * i:奇数 ans[i] = ans[i/2] + 1
     * <p>
     * 状态转移方程：ans[i] = ans[i/2] + (i&1)
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
