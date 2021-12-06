package site.muzhi.leetcode.offer;

/**
 * @author lichuang
 * @date 2020/12/07
 * @description 最大股票利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少
 * 动态规划
 * 状态转移方程：最高利润 = max(前(i-1)日最高利润，第i日价格-前(i-1)日内最低价格)
 */
public class $63_MaxProfit {
    public int maxProfit(int[] prices) {
        int minCost = Integer.MAX_VALUE, prifit = 0;
        for (int price : prices) {
            minCost = Math.min(price, minCost);
            prifit = Math.max(prifit, price - minCost);
        }
        return prifit;
    }
}
