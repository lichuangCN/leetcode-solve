package site.muzhi.leetcode.array;

/**
 * @author: lichuang
 * @date: 2020/03/08
 * @description: 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。
 * 在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。
 * 每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有三种不同的销售方式：
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。
 * 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：
 * 第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * <p>
 * 提示：
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days 按顺序严格递增
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */

public class $983_MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        // 一年中直到某一天的全部花费，lastAllDaysCost[i],直到第i天的总花费
        int[] minAllDaysCost = new int[366];

        // 日票，周票，月票
        int dayTicket = costs[0];
        int weekTicket = costs[1];
        int monthTicket = costs[2];

        //days[]的下标
        int dayIndex = 0;
        for (int today = 1; today < 366; today++) {
            // 遍历完所有的计划日期
            if (dayIndex == days.length) {
                break;
            }
            // 如果今天不是出行日期，直接复制为上一天的花费
            if (days[dayIndex] != today) {
                minAllDaysCost[today] = minAllDaysCost[today - 1];
                continue;
            }
            // 今天是出行日期，比较从上次开始买月票，周票，日票哪一个更便宜
            minAllDaysCost[today] = Math.min(minAllDaysCost[Math.max(0, today - 30)] + monthTicket,
                    Math.min(minAllDaysCost[Math.max(0, today - 1)] + dayTicket, minAllDaysCost[Math.max(0, today - 7)] + weekTicket));
            // 指向下一个出行的日子
            dayIndex++;
        }
        // 返回最后一个出行日的花费
        return minAllDaysCost[days[days.length - 1]];
    }
}
