package site.muzhi.bite;

/**
 * @author lichuang
 * @date 2021/05/12
 * @description 1310. 子数组异或查询
 * <p>
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 */
public class $1310_xorQueries {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m = queries.length;
        int[] xor = new int[n + 1];

        // 计算前缀和
        for (int i = 1; i <= n; i++) {
            xor[i] = xor[i - 1] ^ arr[i - 1];
        }

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0] + 1, r = queries[i][1] + 1;
            res[i] = xor[r] ^ xor[l - 1];
        }
        return res;
    }
}
