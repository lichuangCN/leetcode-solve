package site.muzhi.leetcode.group.offerII;

/**
 * @author lichuang
 * @date 2023/06/09
 * 73.狒狒吃香蕉
 */
public class $73_minEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = max(piles), mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (costTime(mid, piles) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int max(int[] plies) {
        int max = 0;
        for (int p : plies) {
            max = Math.max(max, p);
        }
        return max;
    }

    private int costTime(int k, int[] plies) {
        int cost = 0;
        for (int h : plies) {
            cost += h / k;
            if (h % k != 0) {
                cost++;
            }
        }
        return cost;
    }

}
