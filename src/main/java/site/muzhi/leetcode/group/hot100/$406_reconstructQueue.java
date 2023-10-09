package site.muzhi.leetcode.group.hot100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lichuang
 * @date 2023/10/09
 * 406.根据身高重建队列
 */
public class $406_reconstructQueue {

    public int[][] reconstructQueue(int[][] people) {

        // 1.身高倒序 / 同身高则按照人数正序
        Arrays.sort(people, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return y[0] - x[0];
            }
        });

        // 根据人数插入位置
        ArrayList<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[people.length][2]);
    }
}
