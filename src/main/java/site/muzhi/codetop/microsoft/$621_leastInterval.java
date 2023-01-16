package site.muzhi.codetop.microsoft;

/**
 * @author lichuang
 * @date 2023/01/16
 * 621 任务调度器
 */
public class $621_leastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] cnts = new int[26];
        for (char task : tasks) {
            cnts[task - 'A']++;
        }
        // max 同一种任务最大数
        // 任务最大数为 max 的任务种类
        int max = 0, same = 0;
        for (int cnt : cnts) {
            max = Math.max(max, cnt);
        }
        for (int cnt : cnts) {
            same = (cnt == max) ? same + 1 : same;
        }
        return Math.max(tasks.length, (n + 1) * (max - 1) + same);
    }
}
