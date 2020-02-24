package site.muzhi.greed;

import java.util.PriorityQueue;

/**
 * @author: LiChuang
 * @date: 2020/02/24
 * @description:
 */
public class MinRefuelStops871 {
    /**
     * DP方案
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int len = stations.length;
        // fuels[i] 为加 i 次油能走的最远距离
        int[] fuels = new int[len + 1];
        // fuels[0] 为初始油量
        fuels[0] = startFuel;
        // 依次遍历加油站，第一个加油站索引为0
        for (int i = 0; i < len; i++) {
            // 遍历已经经过的加油站，计算在经过的加油站中加相依次数油行驶的最远距离
            for (int j = i; j >= 0; j--) {
                // 如果当前的油量能够到达下一个加油站
                // 此处需要循环向前迭代，每增加一个加油站，都要重新计算添加i次油能行驶的最远距离
                if (fuels[j] >= stations[i][0]) {
                    // 第i次加油能行驶的最远距离
                    fuels[j + 1] = Math.max(fuels[j + 1], fuels[j] + stations[i][1]);
                }
            }
        }
        // 第i次加油即可到达终点
        for (int i = 0; i < fuels.length; i++) {
            if (fuels[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 最大堆方案
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            return (startFuel > target) ? 0 : -1;
        }
        // 定义一个最大堆，堆顶元素为经历过的加油站中，储油量最大的一个加油站
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        // 行驶过程中油箱的总油量, 加油次数
        int fuels = startFuel, fuelNum = 0;
        // 遍历加油站
        for (int i = 0; i < stations.length; i++) {
            // 如果当前位置的油量无法到达下一个加油站，并且之前经过加油站，挑选储油量最大的加油站进行加油
            while (fuels < stations[i][0] && !heap.isEmpty()) {
                fuels += heap.poll();
                fuelNum++;
            }
            // 如果经过的加油站都加过油，仍旧无法到达下一个加油站
            if (fuels < stations[i][0] && heap.isEmpty()) {
                return -1;
            }
            // 将经过的加油站的储油量入堆
            heap.offer(stations[i][1]);
        }
        // 当遍历完所有加油站，若还不能够到达目的地，再经过的加油站中再次加油
        while (fuels < target) {
            // 当经过的加油站都加过油,仍旧无法达到终点
            if (heap.isEmpty()) {
                return -1;
            }
            fuels += heap.poll();
            fuelNum++;
        }
        return fuelNum;
    }
}
