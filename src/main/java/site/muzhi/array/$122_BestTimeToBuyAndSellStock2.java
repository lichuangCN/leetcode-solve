package site.muzhi.array;

/**
 * @author: lichuang
 * @date: 2020/03/09
 * @description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */

public class $122_BestTimeToBuyAndSellStock2 {

    /**
     * 只要后一天的价格高于前一天的价格，就执行买入卖出
     * 当天股票卖出后可以再次买入
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int prePrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 只要第二天的价格高于前一天，就买入前一天股票，第二天再卖出
            // 此次买入卖出的利润为prices[i] - prePrice
            if (prices[i] > prePrice) {
                maxProfit += prices[i] - prePrice;
            }
            prePrice = prices[i];
        }
        return maxProfit;
    }
}
