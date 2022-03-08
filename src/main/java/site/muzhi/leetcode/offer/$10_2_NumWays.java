package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2022/03/08
 * @description 剑指 Offer 10- II. 青蛙跳台阶问题
 * <p>
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 */
public class $10_2_NumWays {

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int pre = 1, mid = 1, i = 2;
        while (i <= n) {
            int s = (pre + mid) % 1000000007;
            pre = mid;
            mid = s;
            i++;
        }
        return mid;
    }
}
