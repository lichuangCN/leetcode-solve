package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/02
 * 60.排序序列
 */
public class $60_getPermutation {

    public String getPermutation(int n, int k) {

        // 阶乘数组
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        boolean[] used = new boolean[n + 1];

        StringBuilder ans = new StringBuilder();

        travel(ans, n, k, used, factorial, 0);
        return ans.toString();
    }

    private void travel(StringBuilder ans, int n, int k, boolean[] used, int[] factorial, int idx) {
        if (idx == n) {
            return;
        }
        // cnt 每个分支产生的叶子节点数
        int cnt = factorial[n - 1 - idx];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            // 大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫「剪枝」
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            // 所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解
            ans.append(i);
            used[i] = true;
            travel(ans, n, k, used, factorial, idx + 1);
            return;
        }
    }
}
