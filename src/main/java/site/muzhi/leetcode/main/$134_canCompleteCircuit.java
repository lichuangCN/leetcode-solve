package site.muzhi.leetcode.main;

/**
 * @author lichuang
 * @date 2024/01/18
 * 134.加油站
 */
public class $134_canCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length, i = 0;
        // i: 从第i个加油站开始遍历
        while (i < n) {
            // cnt: 本次遍历经历了多少个加油站
            int sumOfGas = 0, sumOfCost = 0, cnt = 0;
            while (cnt < n) {
                int next = (i + cnt) % n;
                sumOfGas += gas[next];
                sumOfCost += cost[next];
                // 当前已经无法到达下一个加油站
                if (sumOfGas < sumOfCost) {
                    break;
                }
                cnt++;
            }

            if (cnt == n) {
                // 刚好经过全部加油站
                return i;
            } else {
                // 当前已经无法到达下一个加油站， 则从下一个加油站开始，重新开始遍历
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
