package site.muzhi.array;

/**
 * @author: LiChuang
 * @date: 2020/02/29
 * @description: 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，
 * 所有这些顾客都会在那一分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 * 示例：
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
public class $1052_GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 不生气时间的顾客总和
        int sum = 0;
        // 计算滑动窗口内，书店老板生气时候的顾客总和
        int max = 0;
        // 滑动窗口活动过程中,每一个窗口的总和
        int tmp = 0;

        // 1.计算不生气时间的顾客总和
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                // 累加顾客数，并将当前分钟的顾客数重置为0
                sum += customers[i];
                customers[i] = 0;
            }
        }

        // 2.寻找第一次生气的时间
        int firstTime = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 1) {
                firstTime = i;
                break;
            }
        }
        // 3.计算第一个窗口值
        for (int i = firstTime; i < firstTime + X && i < customers.length; i++) {
            max += customers[i];
        }

        // 4.开始滑动窗口
        for (int i = firstTime + 1; i <= grumpy.length - X; i++) {
            // 判断新窗口的第一个值是否为老板生气状态
            if (grumpy[i] == 0) {
                // 如果是非生气状态
                continue;
            }
            // 重新计算此后的X分钟内的最多人数
            tmp = 0;
            for (int j = i; j < i + X; j++) {
                tmp += customers[j];
            }
            // 比较当前滑动窗口的总和和之前的最大值
            max = (max > tmp) ? max : tmp;
        }

        // 5.计算最后X分钟内的值
        tmp = 0;
        for (int i = customers.length - 1; i >= customers.length - X && i >= 0; i--) {
            tmp += customers[i];
        }
        // 比较当前滑动窗口的总和和之前的最大值
        max = (max > tmp) ? max : tmp;
        return sum + max;
    }
}
