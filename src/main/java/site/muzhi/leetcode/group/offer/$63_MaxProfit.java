package site.muzhi.leetcode.group.offer;

/**
 * @author lichuang
 * @date 2020/12/07
 * @description 剑指 Offer 63. 股票的最大利润
 * <p>
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少
 * 动态规划
 * 状态转移方程：最高利润 = max(前(i-1)日最高利润，第i日价格-前(i-1)日内最低价格)
 * <p>
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
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

    /**
     * 通过dp数组
     */
    public int maxProfit_2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // [][1]:买入后利润 [][0]:卖出/不卖后利润
        int[][] buffer = new int[prices.length][2];
        buffer[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buffer[i][0] = Math.max(buffer[i - 1][0], buffer[i - 1][1] + prices[i]);
            buffer[i][1] = Math.max(buffer[i - 1][1], -prices[i]);
        }

        return buffer[prices.length - 1][0];
    }
}
