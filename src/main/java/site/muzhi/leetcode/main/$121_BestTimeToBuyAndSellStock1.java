package site.muzhi.leetcode.array;

/**
 * @author: lichuang
 * @date: 2020/03/09
 * @description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），
 * 设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 思想：需要找出股票价格之间最大的差值，
 * 并且最小值[i]和最大值prices[j]之中,i < j
 */

public class $121_BestTimeToBuyAndSellStock1 {

    /**
     * 假设第i天买入股票，在第i天后的日子内将股票卖出，计算买入卖出的利润值
     * 时间复杂度O(n^2)
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            // 计算第i天之后卖出的最高利润
            for (int j = i + 1; j < prices.length; j++) {
                if ((prices[j] - prices[i]) > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }

    /**
     * 寻找当前股票最低价格，如果当前价格高于之前找到的最低价格
     * 则计算当前股票卖出的利润
     * 动态规划：1、比较当天的价格是否是最低的价格，
     * 1.1、如果当天价格低于之前的最低价格，重新记录价格最小值。
     * 1.2、当天价格高于之前的最低价格，计算今天股票卖出的利润与之前卖出利润。
     * 2、比较当前天卖出的利润与之前的利润值
     * 2.1、如果当前天的利润更高，重新记录利润值。
     * 2.2、否则不变。
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            // 如果当前价格低于之前的最小值，则重新设定最小值
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // 如果当前价格大于最小值，计算当前卖出的利润是否大于之前计算的利润
                if (prices[i] - minPrice > maxProfit) {
                    maxProfit = prices[i] - minPrice;
                }
            }
        }
        return maxProfit;
    }
}
