package site.muzhi.binarysearch;

/**
 * @author lichuang
 * @date 2021/04/26
 * @description 1011. 在 D 天内送达包裹的能力
 * <p>
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class $1011_ShipWithinDays {

    public int shipWithinDays(int[] weights, int d) {
        int min = 0, max = 0;
        for (int weight : weights) {
            min = Math.max(min, weight);
            max += weight;
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(weights, mid, d)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }

    private boolean check(int[] weights, int w, int d) {
        int res = 0;
        int len = weights.length;
        for (int i = 0, sum = 0; i < len; sum = 0, res++) {
            while (i < len && sum + weights[i] <= w) {
                sum += weights[i];
                i++;
            }
        }
        return res <= d;
    }
}
