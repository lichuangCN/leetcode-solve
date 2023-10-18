package site.muzhi.leetcode.group.hot100;

/**
 * @author lichuang
 * @date 2023/10/18
 * 621.任务调度器
 */
public class $621_leastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] cnts = new int[26];
        for (char task : tasks) {
            cnts[task - 'A']++;
        }

        int taskMax = 0, sameMaxTask = 0;
        for (int cnt : cnts) {
            taskMax = Math.max(taskMax, cnt);
        }
        for (int cnt : cnts) {
            sameMaxTask = (cnt == taskMax) ? sameMaxTask + 1 : sameMaxTask;
        }

        return Math.max(tasks.length, (n + 1) * (taskMax - 1) + sameMaxTask);
    }
}
