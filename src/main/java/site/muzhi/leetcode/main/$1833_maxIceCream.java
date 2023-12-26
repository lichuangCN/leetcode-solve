package site.muzhi.leetcode.main;

import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/12/22
 * 1833.雪糕的最大数量
 */
public class $1833_maxIceCream {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        for (int cost : costs) {
            if (coins > cost) {
                ans++;
                coins -= cost;
            }
        }
        return ans;
    }
}
