package site.muzhi.leetcode.array;

import java.util.PriorityQueue;

/**
 * @author: LiChuang
 * @date: 2020/02/24
 * @description: 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * <p>
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 */
public class $871_MinimumNumberOfRefuelingStops {
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
