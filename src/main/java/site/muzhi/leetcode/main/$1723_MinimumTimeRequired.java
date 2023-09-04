package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2021/05/08
 * @description 1723. 完成所有工作的最短时间
 * <p>
 * https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
 */
public class $1723_MinimumTimeRequired {

    private int[] jobs;
    int len, k, res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        this.jobs = jobs;
        this.len = jobs.length;
        this.k = k;
        int[] sum = new int[k];
        dfs(0, 0, sum, 0);
        return res;
    }

    /**
     * @param i    当前分配的第i个任务
     * @param used 已经分配的人员
     * @param sum  每个人员手上累计的任务总和
     * @param max  当前最大工作时间
     */
    private void dfs(int i, int used, int[] sum, int max) {
        if (max >= res) {
            return;
        }
        if (i == len) {
            res = max;
            return;
        }
        // 优先分配给无工作的
        if (used < k) {
            sum[used] = jobs[i];
            dfs(i + 1, used + 1, sum, Math.max(sum[used], max));
            sum[used] = 0;
        }
        for (int j = 0; j < used; j++) {
            sum[j] += jobs[i];
            dfs(i + 1, used, sum, Math.max(sum[j], max));
            sum[j] -= jobs[i];
        }
    }
}
